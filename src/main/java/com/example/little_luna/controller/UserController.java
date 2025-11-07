package com.list.todolist2.controller;

import com.example.little_luna.dto.UserRequestDTO;
import com.example.little_luna.dto.UserResponseDTO;
import com.example.little_luna.entity.User;
import com.example.little_luna.repositories.UserRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserRepo userRepository;

    @PostMapping(value = "usuario/cadastro")
    public ResponseEntity<?> save(@Valid @RequestBody UserRequestDTO user) {
        User u = new User(user.getNome(), user.getEmail(), user.getSenha());
        userRepository.save(u);
        return ResponseEntity.ok("Salvo com sucesso!");
    }
    @PostMapping(value = "user/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User findUser = userRepository.findByEmail(user.getEmail());
        if (findUser == null) {
            return ResponseEntity.ok("Usuario não encontrado!");
        }else {
            if (user.getSenha().equals(findUser.getSenha())) {
                return ResponseEntity.ok("Login com sucesso!");
            }else {
                return ResponseEntity.ok("Senha Incorreta!");
            }
        }
    }
    @GetMapping
    public List<UserResponseDTO> mostrarTudo(){
        System.out.println("Users mostrados com sucesso");
        List<User> users = userRepository.findAll();
        List<UserResponseDTO> userResponseDTO = new ArrayList<>();

        for (User user : users) {
            userResponseDTO.add(new UserResponseDTO(user));
        }
        return userResponseDTO;
    }
    @GetMapping(value = "{id}")
    public Optional<User> buscarPorId(@PathVariable int id){
        return userRepository.findById(id);
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deletarPorId(@PathVariable int id) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else {
            userRepository.deleteById(id);
            if (!userRepository.existsById(id)) {
                return ResponseEntity.ok("Deletado com sucesso!");
            } else {
                return ResponseEntity.ok("User não deletado");
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPorId(@PathVariable int id, @RequestBody User user) {
        Optional<User> UserExisty = userRepository.findById(id);

        if (UserExisty.isPresent()) {
            User u = UserExisty.get();
            u.setUsername(user.getUsername());
            u.setEmail(user.getEmail());
            u.setPassword(user.getSenha());
            userRepository.save(u);
            return ResponseEntity.ok(u.toString());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}