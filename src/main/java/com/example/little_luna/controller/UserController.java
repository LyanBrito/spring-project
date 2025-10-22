package com.example.little_luna.controller;

import com.example.little_luna.entity.User;
import com.example.little_luna.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
    @GetMapping(value = "/user/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(userRepo.findAll());
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