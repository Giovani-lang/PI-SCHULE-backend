package com.logonedigital.PI.SCHULE.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnseigantModel {
    private String nom;
    private String prenom;
    private String email;
    private String grade;
}
