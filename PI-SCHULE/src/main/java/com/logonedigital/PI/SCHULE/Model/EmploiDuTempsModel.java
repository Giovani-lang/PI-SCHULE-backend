package com.logonedigital.PI.SCHULE.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmploiDuTempsModel {

    private Integer idClass;
    private String jours;
    private String heure;
    private String matières;
    private String nomProf;
}
