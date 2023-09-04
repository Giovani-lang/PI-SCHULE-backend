package com.logonedigital.PI.SCHULE.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_fiches_de_presence")
@Entity
public class FicheDePresence implements Serializable {
    @Serial
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String matricule;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "nom_&_prenom_de_l'etudiant", unique = true)
    private String nomComplet;
    @Column(name = "nombre_d'heure_d'absence")
    private Integer nombreHeure;

    @ManyToOne(targetEntity = Enseignant.class,fetch = FetchType.EAGER)
    private Enseignant enseignant;

}
