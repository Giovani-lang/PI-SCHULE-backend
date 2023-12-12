package com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto;

import com.logonedigital.PI.SCHULE.Model.AnneeAcademiqueModel;
import com.logonedigital.PI.SCHULE.Model.ClasseModel;
import com.logonedigital.PI.SCHULE.Model.EnseigantModel;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmploiDuTempsResponse {
    private String semestre;
    private AnneeAcademiqueModel annee;
    private ClasseModel classe;
}
