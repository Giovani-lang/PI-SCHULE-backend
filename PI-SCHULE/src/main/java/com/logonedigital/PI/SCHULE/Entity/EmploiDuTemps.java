package com.logonedigital.PI.SCHULE.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tb_Emploi_du_temps")
public class EmploiDuTemps implements Serializable {
    @Serial
    private static final Long serialVersion=1L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_classe")
    private Integer idClass;
    private String jours;
    private String heure;
    private String matières;
    @Column(name = "NomProf_Complet")
    private String nomProf;

}
