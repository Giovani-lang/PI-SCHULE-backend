package com.logonedigital.PI.SCHULE.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PensionModel {
    private String nomElève;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateInscription;
    private Double montantPayé;
    private Double solde;
}
