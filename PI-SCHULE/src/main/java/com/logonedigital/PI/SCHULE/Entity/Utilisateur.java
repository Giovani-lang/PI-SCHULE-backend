package com.logonedigital.PI.SCHULE.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
@Table(name = "tb_utilisateurs")
@Entity
public class Utilisateur implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @Email(message = "invalid email")
    @Column(unique = true)
    protected String email;
    @NotNull(message = "required field")
    @Column(unique = true)
    protected String nom;
    @NotNull(message = "required field")
    @Column(unique = true)
    protected String prenom;
    @NotNull(message = "required field")
    @Column(unique = true, name = "numero_de_telephone")
    protected Integer numeroTel;
    @NotNull(message = "required field")
    @Column(unique = true)
    protected String motDePasse;
    @OneToOne(targetEntity = Role.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Role role;
}
