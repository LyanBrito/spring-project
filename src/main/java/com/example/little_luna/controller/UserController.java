package com.example.little_luna.controller;

import com.example.little_luna.entity.User;
import com.example.little_luna.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRepo userRepo;

    @PostMapping(value = "/user/cadastro")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        User usuario = new User(user.getNome(), user.getEmail(), user.getSenha());
        userRepo.save(user);

        return ResponseEntity.ok(usuario);
//        Augusto galeigo
    }

    @PostMapping(value = "/user/login/")
    public ResponseEntity<?> login(@RequestBody User user) {

        User findUser = userRepo.findByEmail(user.getEmail());
        if (findUser == null) {
            return ResponseEntity.ok("Usuario não encontrado");
        } else {
            if (findUser.getSenha().equals(user.getSenha())) {
                return ResponseEntity.ok("Logado com sucesso");
            } else {
                return ResponseEntity.ok("Senha incorreta");
            }
        }
    }
}