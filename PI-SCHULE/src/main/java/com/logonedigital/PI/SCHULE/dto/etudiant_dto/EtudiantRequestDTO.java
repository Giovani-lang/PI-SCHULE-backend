package com.logonedigital.PI.SCHULE.dto.etudiant_dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto.EmploiDuTempsRequest;
import com.logonedigital.PI.SCHULE.dto.ficheDePresence_dto.FicheDePresenceRequest;
import com.logonedigital.PI.SCHULE.dto.note_dto.NoteRequest;
import com.logonedigital.PI.SCHULE.dto.pensionScolaire_dto.PensionRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtudiantRequestDTO {
    @Email(message = "invalid email")
    @NotEmpty(message = "required field")
    private String email;
    private String image_url;
    @NotEmpty(message = "required field")
    private String nom;
    @NotEmpty(message = "required field")
    private String prenom;
    @NotEmpty(message = "required field")
    private String dateNaissance;
    @NotEmpty(message = "required field")
    private String telephone;
    @NotEmpty(message = "required field")
    private String password;
    @NotEmpty(message = "required field")
    private String genre;
    @NotEmpty(message = "required field")
    private String nom_classe;
    @NotEmpty(message = "required field")
    private String dateInscription;
    @NotEmpty(message = "required field")
    private String annee_academique;



}
