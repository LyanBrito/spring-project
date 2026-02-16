package com.todo.todolist.dto;

import com.todo.todolist.entityModel.Status;
import com.todo.todolist.entityModel.Task;
import com.todo.todolist.entityModel.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskResponseDTO {
    private String name;
    private String description;
    private Status status;
    private User user;

    public TaskResponseDTO(Task task) {
        this.name = task.getName();
        this.description = task.getDescription();
        this.status = task.getStatus();
    }
}
