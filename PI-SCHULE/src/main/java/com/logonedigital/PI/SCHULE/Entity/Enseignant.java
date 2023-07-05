package com.logonedigital.PI.SCHULE.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_enseignants")
@Entity
public class Enseignant extends Utilisateur implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    private String discipline;
    @OneToMany(targetEntity = Note.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Note> noteList = new ArrayList<>();
    @OneToMany(targetEntity = Role.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Releve> releveList =new ArrayList<>();
    @OneToMany(targetEntity = FicheDePresence.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<FicheDePresence> ficheDePresenceList =new ArrayList<>();
}
