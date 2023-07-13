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
@Table(name = "nomElève")
public class PensionScolaire implements Serializable {
    @Serial
    private static final Long serialVersionUID =1L;
        @Id
        @Column (name = "nomElève")
        private String nomElève;
        @Column(unique = true)
        private Date dateInscription;
        @Column(unique = true)
        private Double montantPayé;
        @Column(unique = true)
        private Double solde;

}
