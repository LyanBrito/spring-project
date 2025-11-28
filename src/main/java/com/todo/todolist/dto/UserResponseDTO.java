package com.todo.todolist.dto;

import com.todo.todolist.entiryModel.User;

public class UserResponseDTO {
    private String name;
    private String email;

    public UserResponseDTO() {
    }

    public UserResponseDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

}
