package com.logonedigital.PI.SCHULE.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_enseignants")
@ToString
@Entity
public  class Enseignant implements Serializable {
    @Serial
    private static final Long serialVersionUID = 1L;
    @Id
    @Email(message = "invalid email")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "required field")
    @NotNull(message = "invalid, try again")
    @Column(unique = true)
    private String nom;
    @NotBlank(message = "required field")
    @NotNull(message = "invalid, try again")
    @Column(unique = true)
    private String prenom;
    @NotNull(message = "invalid, try again")
    @Column(unique = true, name = "numero_de_telephone")
    private Integer numeroTel;
    @NotBlank(message = "required field")
    @Column(unique = true)
    @Pattern(regexp = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[#?!@$%^&*-])(?=\\S+$).{8,}",
            message = "your password must contain at least 8 characters including a caps,a lowercase ,a number and {#,?,!,@,$,%,^,&,*,-}" +
                    " and must not contain spaces")
    private String motDePasse;
    @NotBlank(message = "required field")
    @NotNull(message = "invalid, try again")
    private String discipline;


}