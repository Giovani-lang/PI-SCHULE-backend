package com.logonedigital.PI.SCHULE.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    private Long id;
    private String semestre;

    @OneToOne(targetEntity = AnneeAcademique.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "annee_academique", referencedColumnName = "annee_academique")
    private AnneeAcademique annee;

    @OneToOne(targetEntity = Classe.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "classe", referencedColumnName = "nom")
    private Classe classe;

    @OneToMany(targetEntity = Lemploi.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Lemploi> lemplois = new ArrayList<>();

}
