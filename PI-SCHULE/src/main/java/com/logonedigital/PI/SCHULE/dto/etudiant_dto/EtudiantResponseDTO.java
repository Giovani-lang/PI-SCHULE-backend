package com.logonedigital.PI.SCHULE.dto.etudiant_dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.logonedigital.PI.SCHULE.Model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtudiantResponseDTO {
    private String matricule;
    private String email;
    private String image_url;
    private String nom;
    private String prenom;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateNaissance;
    private String telephone;
    private String password;
    private String role;
    private String genre;
    private String niveau;
    private String filiere;
    private String option;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateInscription;
    private AnneeAcademiqueModel anneeAcademique;
    private Date createdAt;
    private Date updatedAt;

}
