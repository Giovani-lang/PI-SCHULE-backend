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
@Table(name = "tb_pension_scolaire")
public class PensionScolaire implements Serializable {
    @Serial
    private static final Long serialVersionUID =1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double pensionAnnuelle;
    private Double totalPaye;
    private Double restePaye;
    private String statut;

    @ManyToOne(targetEntity = Etudiant.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "matricule_etudiant", referencedColumnName = "matricule")
    private Etudiant etudiant;

    @OneToOne(targetEntity = AnneeAcademique.class, fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
    private AnneeAcademique anneeAcademique;




}
