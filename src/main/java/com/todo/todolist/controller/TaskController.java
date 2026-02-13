package com.todo.todolist.controller;

import com.todo.todolist.dto.TaskRequestDTO;
import com.todo.todolist.entityModel.Task;
import com.todo.todolist.services.TaskService;
import jakarta.validation.Path;
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

    @PostMapping("/user/{userId}/task")
    public ResponseEntity<?> addTask(@Valid @RequestBody TaskRequestDTO req, @PathVariable long userId) {
        return ResponseEntity.ok(taskService.addTask(req, userId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(taskService.getTasks());
    }

    @GetMapping("/user/{id}/task")
    public ResponseEntity<?> getTaskByUser(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTasksByUser(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTaskById(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(taskService.deleteTask(id));
    }
    @PutMapping
    public ResponseEntity<?> updateUser(@Valid @RequestBody Long id, Task task) {
        return ResponseEntity.ok(taskService.updateName(id, task));
    }
}
