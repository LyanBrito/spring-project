package com.example.little_luna.controller;

import com.example.little_luna.dto.UserRequestDTO;
import com.example.little_luna.dto.UserResponseDTO;
import com.example.little_luna.entity.User;
import com.example.little_luna.repositories.UserRepo;
import com.example.little_luna.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
//    @Autowired
//    UserRepo userRepository;
//
//    @PostMapping(value = "usuario/cadastro")
//    public ResponseEntity<?> save(@Valid @RequestBody UserRequestDTO user) {
//        User u = new User(user.getNome(), user.getEmail(), user.getSenha());
//        userRepository.save(u);
//        return ResponseEntity.ok("Salvo com sucesso!");
//    }

    @Autowired
    private UserRepo userRepository;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    UserService userService;

    public ResponseEntity<?> save(@Valid @RequestBody UserRequestDTO user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PostMapping(value = "user/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        return ResponseEntity.ok(userService.login(user));
    }

    @GetMapping
    public List<UserResponseDTO> mostrarTudo() {
        return userService.findAll();
    }

    @GetMapping(value = "{id}")
    public Optional<User> buscarPorId(@PathVariable int id) {
        return userService.getById(id);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deletarPorId(@PathVariable int id) {
        return ResponseEntity.ok(userService.deletarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPorId(@PathVariable int id, @RequestBody User user) {
        return ResponseEntity.ok(userService.atualizarPorId(id, user));
    }
}