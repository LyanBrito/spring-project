package com.example.little_luna.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {
    @NotBlank(message = "bota bota na pipoquinha")
    @Column(length = 50, nullable = false)
    protected String nome;
    @NotBlank(message = "bota bota na pipoquinha")
    @Column(length = 50, nullable = false)
    protected String email;
    @NotBlank(message = "bota bota na pipoquinha")
    @Column(length = 50, nullable = false)
    @Size(min = 6, max = 100, message = "senha precisa ter entre 6 e 100 caracteres")
    protected String senha;


    public UserRequestDTO() {

    }
    public UserRequestDTO(String email, String senha, String nome) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
