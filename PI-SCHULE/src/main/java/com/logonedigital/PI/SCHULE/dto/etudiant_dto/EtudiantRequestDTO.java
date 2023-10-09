package com.logonedigital.PI.SCHULE.dto.etudiant_dto;


import com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto.EmploiDuTempsRequest;
import com.logonedigital.PI.SCHULE.dto.ficheDePresence_dto.FicheDePresenceRequest;
import com.logonedigital.PI.SCHULE.dto.note_dto.NoteRequest;
import com.logonedigital.PI.SCHULE.dto.pensionScolaire_dto.PensionRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtudiantRequestDTO {
    @Email(message = "invalid email")
    @NotBlank(message = "required field")
    private String email;
    @NotBlank(message = "required field")
    private String nom;
    @NotBlank(message = "required field")
    private String prenom;
    @NotBlank(message = "required field")
    private String dateNaissance;
    @NotBlank(message = "required field")
    private String telephone;
    @NotBlank(message = "required field")
    private String password;
    @NotBlank(message = "required field")
    private String genre;
    @NotBlank(message = "required field")
    private String niveau;
    @NotBlank(message = "required field")
    private String filiere;
    @NotBlank(message = "required field")
    private String option;
    private EmploiDuTempsRequest emploisDuTemps;
    private List<PensionRequest> pensions;
    private List<NoteRequest> noteRequestList;
    private List<FicheDePresenceRequest> fiches;


}
