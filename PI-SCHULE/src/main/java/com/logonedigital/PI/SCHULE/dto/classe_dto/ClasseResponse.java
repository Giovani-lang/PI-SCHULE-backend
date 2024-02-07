package com.logonedigital.PI.SCHULE.dto.classe_dto;

import com.logonedigital.PI.SCHULE.Model.FiliereModel;
import com.logonedigital.PI.SCHULE.Model.OptionModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClasseResponse {
    private String nom;
    private String niveau;
    private double tarif;
    private FiliereModel filiere;
    private OptionModel option;
}
