package com.logonedigital.PI.SCHULE.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public class User {
    @Id
    @Column(unique = true)
    private String email;
    private String nom;
    private String prenom;
    private String password;
    @Column(unique = true)
    private String telephone;
    private String genre;
    private String role;
}
