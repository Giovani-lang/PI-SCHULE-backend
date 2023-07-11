package com.logonedigital.PI.SCHULE.Entity;

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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdmin;
    @Column(unique = true)
    @NotBlank(message = "inscrivez votre nom correctement")
    private String nom;
    @Column(unique = true)
    @NotBlank(message = "inscrivez votre prenom correctement" )
    private String prenom;
    @Column(unique = true)
    @Email
    @NotBlank(message = "inscrivez votre email correctement")
    private String email;
    @Column(unique = true)
    @NotBlank(message = "inscrivez votre Password correctement")
    private String password;
    @NotBlank(message = "inscrivez votre numéro de téléphone correctement")
    @Column(unique = true)
    private String téléphone;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<EmploiDuTemps> emploisDuTemps;

}
