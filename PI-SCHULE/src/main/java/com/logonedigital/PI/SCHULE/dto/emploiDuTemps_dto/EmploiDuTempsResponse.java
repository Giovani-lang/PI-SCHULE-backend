package com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto;

import com.logonedigital.PI.SCHULE.Model.EnseigantModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmploiDuTempsResponse {
    private Integer idClass;
    private String jours;
    private String heure;
    private String matières;
    private EnseigantModel enseignant;
}
