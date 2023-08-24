package com.logonedigital.PI.SCHULE.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_etudiants")
@Entity
public class Etudiant implements Serializable {

    @Serial
    private static final Long serialVersion=1L;
    @Id
    private String email;
    private String nom;
    private String prenom;
    @Column(name = "date_de_naissance")
    private String dateNaissance;
    @Column(unique = true)
    private String telephone;
    private String password;
    private String genre;
    private String niveau;
    private String filiere;
    private String option;
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
    /*
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Role roles;
    @OneToOne(targetEntity = FicheDePresence.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<FicheDePresence> ficheDePresenceList = new ArrayList<>();
    @OneToMany(targetEntity = Note.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Note> noteList = new ArrayList<>();
    @OneToOne(targetEntity = Releve.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Releve> releveList = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<EmploiDuTemps> emploisDuTemps;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<PensionScolaire> pensionScolaires;
    */
}
