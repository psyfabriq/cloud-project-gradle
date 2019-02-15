package ru.psyfabriq.appgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import ru.psyfabriq.appgateway.filter.PreFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class AppGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppGatewayApplication.class, args);
    }

    @Bean
    public PreFilter simpleFilter() {
        return new PreFilter();
    }
}

