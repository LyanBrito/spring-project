package org.example.ecommerce.dto.services;

import org.example.ecommerce.repositories.UsersRepo;

public class UserService {

    private final UsersRepo usersRepo;

    public UserService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }
    public String addUser(){

        return "Successfully created user!";
    }

}
