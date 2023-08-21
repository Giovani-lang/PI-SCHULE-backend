package com.logonedigital.PI.SCHULE.dto.enseignant_dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnseignantRequestDTO {
    @Email(message = "invalid email")
    @NotBlank(message = "required field")
    private String email;
    @NotBlank(message = "required field")
    private String nom;
    @NotBlank(message = "required field")
    private String prenom;
    @NotNull(message = "required field")
    private String numeroTel;
    @NotBlank(message = "required field")
    /*@Pattern(regexp = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[#?!@$%^&*-])(?=\\S+$).{8,}",
            message = "your password must contain at least 8 characters including a caps,a lowercase ,a number and {#,?,!,@,$,%,^,&,*,-}" +
                    " and must not contain spaces")*/
    private String motDePasse;
    @NotBlank(message = "required field")
    private String discipline;
}