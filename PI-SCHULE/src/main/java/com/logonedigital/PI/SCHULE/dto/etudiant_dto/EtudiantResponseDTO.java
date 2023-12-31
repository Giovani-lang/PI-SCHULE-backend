package com.logonedigital.PI.SCHULE.dto.etudiant_dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.logonedigital.PI.SCHULE.Model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtudiantResponseDTO {
    private String email;
    private String image_url;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String telephone;
    private String password;
    private String role;
    private String genre;
    private String niveau;
    private String filiere;
    private String option;
    private Date createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

}
