package ru.psyfabriq.auth.service;

import ru.psyfabriq.auth.entity.Role;

import java.util.Optional;

public interface RoleService extends ExecutestService<Role, Role> {
    boolean existsByName(String name);

    Optional<Role> findByName(String name);
}
