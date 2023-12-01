package com.logonedigital.PI.SCHULE.dto.paiement_dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaiementRequest {
    @NotEmpty(message = "required field")
    private String matricule_etd;
    @NotEmpty(message = "required field")
    private String libelle;
    @NotNull(message = "required field")
    private Double montant;
}
