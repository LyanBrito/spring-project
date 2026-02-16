package com.todo.todolist.dto;

import com.todo.todolist.entityModel.Task;
import com.todo.todolist.entityModel.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserRequestDTO {
    private String name;
    private String email;
    private String password;
    private List<Task> tasks = new ArrayList<>();

    public UserRequestDTO(User user) {
        this.email = user.getEmail();
        this.name = user.getName();
        this.password = user.getPassword();
    }
}
