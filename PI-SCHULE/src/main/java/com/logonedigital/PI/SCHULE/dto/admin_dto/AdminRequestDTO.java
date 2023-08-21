package com.logonedigital.PI.SCHULE.dto.admin_dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AdminRequestDTO {
    @Email
    @NotBlank(message = "invalid email")
    private String email;
    @NotBlank(message =  "required field")
    private String nom;
    @NotBlank(message =  "required field")
    private String prenom;
    @NotBlank(message =  "required field")
    private String password;
    @NotBlank(message =  "required field")
    private String téléphone;
}
