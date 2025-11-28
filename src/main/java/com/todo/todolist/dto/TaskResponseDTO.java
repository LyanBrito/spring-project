package com.todo.todolist.dto;

import com.todo.todolist.entiryModel.Status;
import com.todo.todolist.entiryModel.Task;
import com.todo.todolist.entiryModel.User;

public class TaskResponseDTO {
    private String name;
    private String description;
    private Status status;

    public TaskResponseDTO() {
    }
    public TaskResponseDTO(Task task) {
        this.name = task.getName();
        this.description = task.getDescription();
        this.status = task.getStatus();
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
}
