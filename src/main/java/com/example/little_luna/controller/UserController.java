package com.example.little_luna.controller;

import com.example.little_luna.entity.User;
import com.example.little_luna.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class UserController {
    @Autowired
    UserRepo userr;

    @PostMapping
    public User salvar() {
        User Banana = new User("sdfghgfd@com", "Bananal", "b4n4n4");
        return userr.save(Banana);
    }

    @GetMapping
    public List<User> mostrar() {
        List<User> users = userr.findAll();
//        users.add(Banana);
        return users;
//      return user.findAll();
    }


}
