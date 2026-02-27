package org.example.ecommerce.services;

import org.example.ecommerce.dto.users.UsersReq;
import org.example.ecommerce.dto.users.UsersRes;
import org.example.ecommerce.entitys.Users;
import org.example.ecommerce.repositories.UsersRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UsersRepo usersRepo;

    public UserService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    public UsersRes showAll() {
        List<Users> users = usersRepo.findAll();
        return (UsersRes) users.stream().map(UsersRes::new).toList();
    }

    public String newUser(UsersReq req) {
        Users u = new Users(req.getName(), req.getEmail(), req.getPassword());
        usersRepo.save(u);
        return "creado";
    }


}
