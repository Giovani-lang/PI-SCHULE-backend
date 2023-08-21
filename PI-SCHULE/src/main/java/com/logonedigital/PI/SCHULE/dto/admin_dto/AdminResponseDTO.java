package com.logonedigital.PI.SCHULE.dto.admin_dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminResponseDTO {
    private String email;
    private String nom;
    private String prenom;
    private String password;
    private String téléphone;
    private Date createdAt;
    private Date updatedAt;
}
