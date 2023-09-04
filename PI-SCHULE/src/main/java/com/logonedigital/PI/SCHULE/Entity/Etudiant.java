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

//    @OneToOne(targetEntity = FicheDePresence.class,fetch = FetchType.EAGER)
//    private List<FicheDePresence> ficheDePresenceList = new ArrayList<>();
//    @OneToMany(targetEntity = Note.class,fetch = FetchType.EAGER)
//    private List<Note> noteList = new ArrayList<>();
//    @OneToOne(targetEntity = Releve.class,fetch = FetchType.EAGER)
//    private List<Releve> releveList = new ArrayList<>();
//    @OneToOne(fetch = FetchType.EAGER)
//    private List<EmploiDuTemps> emploisDuTemps;
//    @OneToOne(fetch = FetchType.EAGER)
//    private List<PensionScolaire> pensionScolaires;

}
