package com.todo.todolist.dto;

import com.todo.todolist.entityModel.Status;
import com.todo.todolist.entityModel.Task;
import com.todo.todolist.entityModel.User;

public class TaskResponseDTO {
    private String name;
    private String description;
    private Status status;
    private User user;

    public TaskResponseDTO() {
    }
    public TaskResponseDTO(Task task) {
        this.name = task.getName();
        this.description = task.getDescription();
        this.status = task.getStatus();
        this.user = task.getUser();
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }
}
