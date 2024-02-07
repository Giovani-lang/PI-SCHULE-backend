package com.logonedigital.PI.SCHULE.dto.tarif_dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarifRequest {
    private String niveau;
    private double montant;
    private String option;
}
