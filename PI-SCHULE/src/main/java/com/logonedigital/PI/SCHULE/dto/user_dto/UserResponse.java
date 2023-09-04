package com.logonedigital.PI.SCHULE.dto.user_dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String email;
    private String nom;
    private String prenom;
    private String password;
    private String telephone;
    private String genre;
    private String role;
}
