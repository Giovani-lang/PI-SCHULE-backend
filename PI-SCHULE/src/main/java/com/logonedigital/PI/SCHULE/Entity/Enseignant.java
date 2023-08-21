package com.logonedigital.PI.SCHULE.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_enseignants")
@Entity
public  class Enseignant implements Serializable {
    @Serial
    private static final Long serialVersionUID = 1L;
    @Id
    private String email;
    private String nom;
    private String prenom;
    @Column(unique = true, name = "numero_de_telephone")
    private String numeroTel;
    private String motDePasse;
    private String discipline;
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Temporal(TemporalType.DATE)
    private Date updateddAt;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Role> roles;

    @OneToMany(targetEntity = FicheDePresence.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<FicheDePresence> ficheDePresenceList = new ArrayList<>();
    @OneToMany(targetEntity = Note.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Note> noteList = new ArrayList<>();
    @OneToMany(targetEntity = Releve.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Releve> releveList = new ArrayList<>();
}
