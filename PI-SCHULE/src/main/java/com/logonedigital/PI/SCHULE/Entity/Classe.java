package com.logonedigital.PI.SCHULE.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_classes")
public class Classe implements Serializable {
    @Serial
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String niveau;
    @ManyToOne(fetch = FetchType.EAGER)
    private Filiere filiere;
    @OneToOne(fetch = FetchType.EAGER)
    private Option option;

}
