package com.example.little_luna.controller;

import com.example.little_luna.entity.User;
import com.example.little_luna.repositories.UserRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    UserRepo userRepo;

    @PostMapping(value = "/user/cadastro")
    public ResponseEntity<?> saveUser(@Valid @RequestBody User user) {
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

    @GetMapping(value = "/user/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(userRepo.findAll());
    }

    @GetMapping(value = "{id}")
    public Optional<User> findById(@PathVariable int id) {
        return userRepo.findById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletar(@PathVariable int id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Excluido com Sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esse ID não existe");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable int id, @RequestBody User newUser) {
        Optional<User> ExistedUser = userRepo.findById(id);

        if (ExistedUser.isPresent()) {
            User User = ExistedUser.get();
            User.setNome(newUser.getNome());
            User.setSenha(newUser.getSenha());
            userRepo.save(User);
            return ResponseEntity.ok(User);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esse ID não existe");
        }
    }
}