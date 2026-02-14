package com.todo.todolist.controller;

import com.todo.todolist.dto.UserRequestDTO;
import com.todo.todolist.entityModel.User;
import com.todo.todolist.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/newUser")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserRequestDTO req) {
        return ResponseEntity.ok(userService.save(req));
    }

    @GetMapping("/showAll")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/showUser/{id}")
    public ResponseEntity<?> getUserById(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUserById(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteById(id));
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody Long id, User user) {
        return ResponseEntity.ok(userService.updateById(id, user));
    }
}