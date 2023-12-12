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
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class User implements Serializable {
    @Serial
    private static final Long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(unique = true)
    protected String email;
    protected String image_url;
    protected String nom;
    protected String prenom;
    protected String password;
    @Column(unique = true)
    protected String telephone;
    protected String genre;
    protected String role;
}
