package com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmploiDuTempsRequest {
    @NotBlank(message = "Required field")
    private String semestre;
    @NotBlank(message = "Required field")
    private String annee_academique;
    @NotBlank(message = "Required field")
    private String nom_classe;
}
