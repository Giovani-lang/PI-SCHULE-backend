package com.logonedigital.PI.SCHULE.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_ligne_emploi_du_temps")
public class Lemploi implements Serializable {
    @Serial
    private static final Long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date Jour;
    private String debut;
    private String fin;
    private int duree;
    @OneToOne(targetEntity = Matiere.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "matiere", referencedColumnName = "intitule")
    private Matiere matiere;
    @OneToOne(targetEntity = Enseignant.class,fetch = FetchType.EAGER)
    @JoinColumns ({
            @JoinColumn (name="nom_enseignant", referencedColumnName="nom"),
            @JoinColumn (name="prenom_enseignant", referencedColumnName="prenom")
    })
    private Enseignant enseignant;
    @OneToOne(targetEntity = Classe.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "classe", referencedColumnName = "nom")
    private Classe classe;

}
