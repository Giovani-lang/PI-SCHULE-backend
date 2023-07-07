package com.logonedigital.PI.SCHULE.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
@Table(name = "tb_enseignants")
@Entity
public  class Enseignant implements Serializable {
    @Serial
    private static final Long serialVersionUID = 1L;
    @Id
    @Email(message = "invalid email")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "required field")
    @Column(unique = true)
    private String nom;
    @NotBlank(message = "required field")
    @Column(unique = true)
    private String prenom;
    @NotNull(message = "required field")
    @Column(unique = true, name = "numero_de_telephone")
    private Integer numeroTel;
    @NotBlank(message = "required field")
    @Column(unique = true)
    @Pattern(regexp = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[#?!@$%^&*-])(?=\\S+$).{8,}",
             message = "your password must contain at least 8 characters including a caps,a lowercase ,a number and {#,?,!,@,$,%,^,&,*,-}" +
                       " and must not contain spaces")
    private String motDePasse;
    @NotBlank(message = "required field")
    private String discipline;
}
