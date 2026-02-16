package com.todo.todolist.dto;

import com.todo.todolist.entityModel.Status;
import com.todo.todolist.entityModel.Task;
import com.todo.todolist.entityModel.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class TaskRequestDTO {
    private String name;
    private String description;
    private LocalDate dueDate;
    private LocalDate createdDate;
    private Status status;
    private User user;

    public TaskRequestDTO(Task task) {
        this.name = task.getName();
        this.description = task.getDescription();
        this.dueDate = task.getDueDate();
        this.status = task.getStatus();
    }
}
