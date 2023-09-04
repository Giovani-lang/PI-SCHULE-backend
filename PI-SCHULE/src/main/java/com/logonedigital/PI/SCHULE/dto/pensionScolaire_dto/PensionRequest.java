package com.logonedigital.PI.SCHULE.dto.pensionScolaire_dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PensionRequest {
    private String nomElève;
    private Double montantPayé;
    private Double solde;
}
