package com.logonedigital.PI.SCHULE.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.logonedigital.PI.SCHULE.Enumeration.RoleName;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table (name = "tb_admin")
public class Administration implements Serializable {

    @Serial
    private static final Long serialVersionUID =1L;

    @Id
    private String email;
    private String nom;
    private String prenom;
    private String password;
    @Column(unique = true)
    private String téléphone;
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Temporal(TemporalType.DATE)
    private Date updateddAt;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Role> roles;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<EmploiDuTemps> emploisDuTemps;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<PensionScolaire> pensionScolaires;

}
