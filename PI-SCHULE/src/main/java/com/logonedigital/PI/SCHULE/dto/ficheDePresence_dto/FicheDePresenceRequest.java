package com.logonedigital.PI.SCHULE.dto.ficheDePresence_dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FicheDePresenceRequest {
    @NotBlank(message = "required field")
    private String nomComplet;
    @NotNull(message = "required field")
    @Min(value = 1, message = "must be greater than or equal to 1")
    private Integer nombreHeure;
    private String nomEnseignant;
}
