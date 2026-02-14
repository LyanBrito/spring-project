package org.example.ecommerce.services;

import org.example.ecommerce.repositories.UsersRepo;

public class UsersService {
    private final UsersRepo usersRepo;

    public UsersService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }
}
