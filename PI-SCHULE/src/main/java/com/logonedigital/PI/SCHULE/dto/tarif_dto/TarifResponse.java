package com.logonedigital.PI.SCHULE.dto.tarif_dto;

import com.logonedigital.PI.SCHULE.Model.OptionModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarifResponse {
    private Long id;
    private String niveau;
    private double montant;
    private OptionModel options;
}
