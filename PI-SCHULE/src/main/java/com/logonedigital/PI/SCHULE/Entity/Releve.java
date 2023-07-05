package com.logonedigital.PI.SCHULE.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_releves")
@Entity
public class Releve implements Serializable {
    @Serial
    private static final Long serialVersion =1L;
    @Id
    private String module;
    private String nomMatiere;
    private Integer coeffient;
    private double moyenne;
    private String statut;

}
