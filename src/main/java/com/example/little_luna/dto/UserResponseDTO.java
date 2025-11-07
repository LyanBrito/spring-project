package com.example.little_luna.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserResponseDTO {
    @NotBlank(message = "Coloca essa porra, caralho")
    private String username;
    @Email
    @Column(unique = true)
    @NotBlank(message = "Coloca essa porra, caralho")
    private String email;
    @NotBlank(message = "Coloca essa porra, caralho")
    @Size(min = 8, max = 20, message = "Tem que colocar no tamanho da tua pica, média")
    private String password;

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
