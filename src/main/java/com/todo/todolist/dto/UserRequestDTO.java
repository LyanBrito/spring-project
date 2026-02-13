package com.todo.todolist.dto;

import com.todo.todolist.entityModel.Task;
import com.todo.todolist.entityModel.User;

import java.util.ArrayList;
import java.util.List;

public class UserRequestDTO {
    private String name;
    private String email;
    private String password;
    private List<Task> tasks = new ArrayList<>();

    public UserRequestDTO() {
    }

    public UserRequestDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.tasks = user.getTasks();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
