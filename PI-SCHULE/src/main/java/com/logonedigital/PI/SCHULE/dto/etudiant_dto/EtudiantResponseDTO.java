package com.logonedigital.PI.SCHULE.dto.etudiant_dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtudiantResponseDTO {
    private String email;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String telephone;
    private String password;
    private String genre;
    private String niveau;
    private String filiere;
    private String option;
    private Date createdAt;
    private Date updatedAt;
}