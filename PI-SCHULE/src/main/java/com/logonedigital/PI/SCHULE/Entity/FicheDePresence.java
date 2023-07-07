package com.logonedigital.PI.SCHULE.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String matricule;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "required field format (dd-MM-yyyy)")
    private Date date;
    @Column(name = "nom_&_prenom")
    @NotBlank(message = "required field")
    private String nomComplet;
    @NotNull (message = "required field")
    @Min(value = 1,message = "must be greater than or equal to 1")
    @Column(name = "nombre_d'heure_d'absence")
    private Integer nombreHeure;

}
