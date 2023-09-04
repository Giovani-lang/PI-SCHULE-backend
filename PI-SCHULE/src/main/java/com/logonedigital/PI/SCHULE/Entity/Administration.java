package com.logonedigital.PI.SCHULE.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table (name = "tb_admin")
public class Administration extends User{

    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<EmploiDuTemps> emploisDuTemps;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<PensionScolaire> pensionScolaires;

}
