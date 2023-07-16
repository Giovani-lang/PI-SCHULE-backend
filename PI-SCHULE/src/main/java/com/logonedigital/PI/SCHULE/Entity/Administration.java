package com.logonedigital.PI.SCHULE.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table (name = "Admin")
public class Administration implements Serializable {

    @Serial
    private static final Long serialVersionUID =1L;

    @Id
    @Column(unique = true)
    @Email
    @NotBlank(message = "inscrivez votre email correctement")
    private String email;
    @NotBlank(message = "inscrivez votre nom correctement")
    private String nom;
    @NotBlank(message = "inscrivez votre prenom correctement" )
    private String prenom;

    @Column(unique = true)
    @NotBlank(message = "inscrivez votre Password correctement")
    private String password;
    @NotBlank(message = "inscrivez votre numéro de téléphone correctement")
    @Column(unique = true)
    private String téléphone;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<EmploiDuTemps> emploisDuTemps;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<PensionScolaire> pensionScolaires;

}
