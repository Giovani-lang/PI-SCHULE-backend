package com.logonedigital.PI.SCHULE.dto.paiement_dto;

import com.logonedigital.PI.SCHULE.Model.EtudiantModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaiementResponse {
    private Long id;
    private EtudiantModel etudiant;
    private Date date;
    private String libelle;
    private Double montant;
}
