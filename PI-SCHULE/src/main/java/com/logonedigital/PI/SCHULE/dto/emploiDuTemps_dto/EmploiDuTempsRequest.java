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
    private String jours;
    @NotBlank(message = "Required field")
    private String heure;
    @NotBlank(message = "Required field")
    private String matières;
    @NotBlank(message = "Required field")
    private String nomProf;
}
