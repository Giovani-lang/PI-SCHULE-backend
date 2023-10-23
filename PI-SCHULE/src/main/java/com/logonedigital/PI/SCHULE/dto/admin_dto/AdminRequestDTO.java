package com.logonedigital.PI.SCHULE.dto.admin_dto;



import com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto.EmploiDuTempsRequest;
import com.logonedigital.PI.SCHULE.dto.pensionScolaire_dto.PensionRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AdminRequestDTO {
    @Email(message = "invalid email")
    @NotBlank(message = "invalid email")
    private String email;
    private String image_url;
    @NotBlank(message =  "required field")
    private String nom;
    @NotBlank(message =  "required field")
    private String prenom;
    @NotBlank(message =  "required field")
    private String password;
    @NotBlank(message =  "required field")
    private String telephone;
    @NotBlank(message =  "required field")
    private String genre;

}
