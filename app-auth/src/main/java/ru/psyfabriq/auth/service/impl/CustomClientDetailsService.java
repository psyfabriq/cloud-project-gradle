package ru.psyfabriq.auth.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.psyfabriq.auth.entity.Client;
import ru.psyfabriq.auth.repository.ClientRepository;
//import ru.psyfabriq.library.utils.logging.annotation.LogBefore;

import java.util.Collections;
import java.util.Optional;

@Service
public class CustomClientDetailsService implements ClientDetailsService {

    private static final Logger log = LoggerFactory.getLogger(CustomClientDetailsService.class);

    private final ClientRepository clientRepository;
    private final LoadBalancerClient loadBalancerClient;


    @Autowired
    public CustomClientDetailsService(ClientRepository clientRepository, LoadBalancerClient loadBalancerClient) {
        this.clientRepository = clientRepository;
        this.loadBalancerClient = loadBalancerClient;
    }

    @Override
    @Transactional
   // @LogBefore
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Client client = clientRepository.findByClientId(clientId)
                .orElseThrow(() -> new ClientRegistrationException(String.format("no client %s registered", clientId))
                );
        BaseClientDetails details = new BaseClientDetails(
                client.getClientId(),
                client.getResourceIds(),
                client.getScope(),
                client.getAuthorizedGrantTypes(),
                client.getAuthorities(),
                client.getWebServerRedirectUri());

        if (client.getWebServerRedirectUri() != null) {
            String greetingsClientRedirectUri = Optional.ofNullable(this.loadBalancerClient.choose(client.getWebServerRedirectUri()))
                    .map(serviceInstance -> String.format("http://%s:%s/login", serviceInstance.getHost(), serviceInstance.getPort()))
                    .orElseThrow(() -> new ClientRegistrationException("coudn`t find and bind greetings-client IP"));

            details.setRegisteredRedirectUri(Collections.singleton(greetingsClientRedirectUri));
        }

        details.setAutoApproveScopes(Collections.singleton(client.getAutoapprove()));
        details.setClientSecret(client.getClientSecret());
        //details.setResourceIds(Collections.singleton(client.getResourceIds()));

        return details;
    }
}
