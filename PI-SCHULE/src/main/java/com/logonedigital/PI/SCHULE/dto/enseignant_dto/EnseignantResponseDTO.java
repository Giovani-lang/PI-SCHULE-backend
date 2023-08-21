package com.logonedigital.PI.SCHULE.dto.enseignant_dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnseignantResponseDTO {
    private String email;
    private String nom;
    private String prenom;
    private String numeroTel;
    private String motDePasse;
    private String discipline;
    private Date createdAt;
    private Date updateddAt;
}
