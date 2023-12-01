package com.logonedigital.PI.SCHULE.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_annees_academiques")
public class AnneeAcademique {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "annee_academique")
    private String annees;

    @OneToMany(mappedBy = "anneeAcademique",targetEntity = Etudiant.class,fetch = FetchType.EAGER,cascade =  CascadeType.ALL)
    private List<Etudiant> etudiants =new ArrayList<>();
}
