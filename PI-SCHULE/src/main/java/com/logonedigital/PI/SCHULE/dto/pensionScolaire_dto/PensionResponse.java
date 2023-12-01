package com.logonedigital.PI.SCHULE.dto.pensionScolaire_dto;

import com.logonedigital.PI.SCHULE.Model.EtudiantModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PensionResponse {
    private Long id;
    private EtudiantModel etudiant;
    private Double pensionAnnuelle;
    private Double totalPaye;
    private String statut;
}
