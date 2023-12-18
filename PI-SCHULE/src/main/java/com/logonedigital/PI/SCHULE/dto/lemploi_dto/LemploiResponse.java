package com.logonedigital.PI.SCHULE.dto.lemploi_dto;

import com.logonedigital.PI.SCHULE.Model.ClasseModel;
import com.logonedigital.PI.SCHULE.Model.EnseigantModel;
import com.logonedigital.PI.SCHULE.Model.MatiereModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LemploiResponse {

    private Long id;
    private String Jour;
    private String debut;
    private String fin;
    private int duree;
    private MatiereModel matiere;
    private EnseigantModel enseignant;
    private ClasseModel classe;
}
