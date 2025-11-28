package com.todo.todolist.controller;

import com.todo.todolist.dto.UserRequestDTO;
import com.todo.todolist.entiryModel.Task;
import com.todo.todolist.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<?> addTask(@Valid @RequestBody UserRequestDTO req) {
        return ResponseEntity.ok(taskService.saveTask(req));
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @GetMapping
    public ResponseEntity<?> getUserById(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(taskService.getById(id));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserById(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(taskService.deleteById(id));
    }
    @PutMapping
    public ResponseEntity<?> updateUser(@Valid @RequestBody Long id, Task task) {
        return ResponseEntity.ok(taskService.updateById(id, task));
    }
}
