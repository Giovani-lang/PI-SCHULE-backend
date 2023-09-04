package com.logonedigital.PI.SCHULE.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FicheDePresenceModel {
    private String matricule;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String nomComplet;
    private Integer nombreHeure;
}
