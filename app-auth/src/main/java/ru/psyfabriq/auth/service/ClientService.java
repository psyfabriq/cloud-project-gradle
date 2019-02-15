package ru.psyfabriq.auth.service;

import ru.psyfabriq.auth.entity.Client;

public interface ClientService extends ExecutestService<Client, Client> {
    boolean existsByClientIde(String clientId);
}
