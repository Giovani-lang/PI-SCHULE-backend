package com.logonedigital.PI.SCHULE.dto.enseignant_dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.logonedigital.PI.SCHULE.Model.FicheDePresenceModel;
import com.logonedigital.PI.SCHULE.Model.NoteModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnseignantResponseDTO {
    private String email;
    private String image_url;
    private String nom;
    private String prenom;
    private String password;
    private String telephone;
    private String genre;
    private String discipline;
    private String role;
    private Date createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

}
