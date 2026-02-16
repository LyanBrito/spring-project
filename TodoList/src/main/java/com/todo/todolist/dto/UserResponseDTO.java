package com.todo.todolist.dto;

import com.todo.todolist.entityModel.Task;
import com.todo.todolist.entityModel.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserResponseDTO {
    private String name;
    private String email;
    private List<Task> tasks = new ArrayList<>();

    public UserResponseDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
