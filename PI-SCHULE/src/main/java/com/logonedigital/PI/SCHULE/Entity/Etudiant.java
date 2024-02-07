package com.logonedigital.PI.SCHULE.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_etudiants")
@Entity
public class Etudiant extends User {

    private String matricule;
    private String dateNaissance;
    private String niveau;
    private String filiere;
    private String option;
    private String dateInscription;
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne(targetEntity = AnneeAcademique.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "annee_academique", referencedColumnName = "annee_academique")
    private AnneeAcademique anneeAcademique;

    @ManyToOne (targetEntity = Classe.class, fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
    @JoinColumn(name = "classe", referencedColumnName = "nom")
    private Classe classe;

    @OneToMany(targetEntity = FicheDePresence.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<FicheDePresence> ficheDePresence = new ArrayList<>();
    @OneToMany(targetEntity = Note.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Note> notes = new ArrayList<>();

}
