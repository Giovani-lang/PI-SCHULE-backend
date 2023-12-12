package com.logonedigital.PI.SCHULE.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_enseignants")
@Entity
public  class Enseignant extends User {

    private Date createdAt;
    private Date updatedAt;

    @OneToOne(targetEntity = AnneeAcademique.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "annee_academique", referencedColumnName = "annee_academique")
    private AnneeAcademique annee;



    @OneToMany(targetEntity = FicheDePresence.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<FicheDePresence> ficheDePresenceList = new ArrayList<>();
    @OneToMany(targetEntity = Note.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Note> noteList = new ArrayList<>();
}
