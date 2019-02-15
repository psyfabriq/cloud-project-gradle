package ru.psyfabriq.auth.service;

import ru.psyfabriq.auth.AppAccountForm;
import ru.psyfabriq.auth.entity.Account;

public interface AccountService extends ExecutestService<Account, AppAccountForm> {

    Account getByNameOrEmail(String name, String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsById(String id);

    boolean delete(String id);
}
