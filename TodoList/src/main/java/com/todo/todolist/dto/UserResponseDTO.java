package com.todo.todolist.dto;

import com.todo.todolist.entityModel.Task;
import com.todo.todolist.entityModel.User;

import java.util.ArrayList;
import java.util.List;

public class UserResponseDTO {
    private String name;
    private String email;
    private List<Task> tasks = new ArrayList<>();

    public UserResponseDTO() {
    }

    public UserResponseDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.tasks = user.getTasks();

    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
