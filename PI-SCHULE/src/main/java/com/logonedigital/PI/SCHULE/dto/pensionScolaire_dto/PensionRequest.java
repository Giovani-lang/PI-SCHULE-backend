package com.logonedigital.PI.SCHULE.dto.pensionScolaire_dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PensionRequest {
    @NotEmpty(message = "required field")
    private String matricule_etd;
    @NotNull(message = "required field")
    private Long annee_academique;
}
