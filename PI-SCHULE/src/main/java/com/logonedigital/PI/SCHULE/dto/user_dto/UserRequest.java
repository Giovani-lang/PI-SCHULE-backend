package com.logonedigital.PI.SCHULE.dto.user_dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @Email(message = "invalid email")
    @NotBlank(message = "required field")
    private String email;
    @NotBlank(message = "required field")
    private String nom;
    @NotBlank(message = "required field")
    private String prenom;
    @NotBlank(message = "required field")
    private String password;
    @NotBlank(message = "required field")
    private String telephone;
    @NotBlank(message = "required field")
    private String genre;
    @NotBlank(message = "required field")
    private String role;
}
