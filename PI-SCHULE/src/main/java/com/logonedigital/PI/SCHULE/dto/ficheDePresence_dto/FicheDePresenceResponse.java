package com.logonedigital.PI.SCHULE.dto.ficheDePresence_dto;


import com.logonedigital.PI.SCHULE.Model.EnseigantModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FicheDePresenceResponse {
    private String matricule;
    private Date date;
    private String nomComplet;
    private Integer nombreHeure;
    private EnseigantModel enseignant;
}
