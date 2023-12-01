package com.logonedigital.PI.SCHULE.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor(staticName = "bill")
@Setter
@Getter
@Entity
@Table(name = "pension_scolaire")
public class PensionScolaire implements Serializable {
    @Serial
    private static final Long serialVersionUID =1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double pensionAnnuelle;
    private Double totalPaye = 0.0;
    private String statut;

    @ManyToOne(targetEntity = Etudiant.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "matricule_etudiant", referencedColumnName = "matricule")
    private Etudiant etudiant;

    public String getStatut(){
        if (this.totalPaye >= this.pensionAnnuelle){
            return this.statut = "soldée";
        }return this.statut = "non_soldée";
    }



}
