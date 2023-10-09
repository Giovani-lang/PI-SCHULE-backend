package com.logonedigital.PI.SCHULE.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_etudiants")
@Entity
public class Etudiant extends User {
    @Column(name = "date_de_naissance")
    private String dateNaissance;
    private String niveau;
    private String filiere;
    private String option;
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    @OneToMany(targetEntity = FicheDePresence.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<FicheDePresence> ficheDePresence = new ArrayList<>();
    @OneToMany(targetEntity = Note.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Note> notes = new ArrayList<>();
//    @OneToOne(targetEntity = Releve.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    private List<Releve> releveList = new ArrayList<>();
    @OneToOne(targetEntity = EmploiDuTemps.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private EmploiDuTemps emploiDuTemps;
    @OneToMany(targetEntity = PensionScolaire.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<PensionScolaire> pensionScolaires = new ArrayList<>();

}
