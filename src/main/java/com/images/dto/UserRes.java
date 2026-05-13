package com.images.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.images.entities.User}
 */
@Value
public class UserRes implements Serializable {
    Long id;
    String name;
    @Email
    String email;
    @NotBlank(message = "pode nao fih")
    String photo;
}