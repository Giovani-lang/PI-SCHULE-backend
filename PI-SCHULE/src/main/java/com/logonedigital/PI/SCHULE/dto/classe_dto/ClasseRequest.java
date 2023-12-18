package com.logonedigital.PI.SCHULE.dto.classe_dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClasseRequest {
    @NotEmpty(message = "required field")
    private String nom;
    @NotEmpty(message = "required field")
    private String nom_filiere;
    @NotEmpty(message = "required field")
    private String nom_option;
}
