package com.logonedigital.PI.SCHULE.Entity;

import jakarta.persistence.*;
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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;
    @Column(name = "nom_&_prenom")
    private String nomComplet;
    @Column(name = "nombre_d'heure_d'absence")
    private Integer nombreHeure;

}
