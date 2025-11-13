package com.example.little_luna.dto;

import com.example.little_luna.entity.User;

public class UserResponseDTO {
    private String username;
    private String email;
    private String password;

    public UserResponseDTO(User user) {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
