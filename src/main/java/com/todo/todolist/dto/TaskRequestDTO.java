package com.todo.todolist.dto;

import com.todo.todolist.entityModel.Status;
import com.todo.todolist.entityModel.Task;
import com.todo.todolist.entityModel.User;

import java.time.LocalDate;

public class TaskRequestDTO {
    private String name;
    private String description;
    private LocalDate dueDate;
    private LocalDate createdDate;
    private Status status;
    private User user;

    public TaskRequestDTO() {
    }

    public TaskRequestDTO(Task task) {
        this.createdDate = task.getCreatedDate();
        this.description = task.getDescription();
        this.dueDate = task.getDueDate();
        this.name = task.getName();
        this.status = task.getStatus();
        this.user = task.getUser();
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
