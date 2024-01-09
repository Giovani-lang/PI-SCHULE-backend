package com.logonedigital.PI.SCHULE.dto.paiement_dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.logonedigital.PI.SCHULE.Model.AnneeAcademiqueModel;
import com.logonedigital.PI.SCHULE.Model.EtudiantModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaiementResponse {
    private Long id;
    private EtudiantModel etudiant;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date;
    private String libelle;
    private Double montant;
    private AnneeAcademiqueModel anneeAcademique;
}
