package com.logonedigital.PI.SCHULE.dto.enseignant_dto;

import com.logonedigital.PI.SCHULE.dto.ficheDePresence_dto.FicheDePresenceRequest;
import com.logonedigital.PI.SCHULE.dto.note_dto.NoteRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnseignantRequestDTO {
    @Email(message = "invalid email")
    @NotBlank(message = "required field")
    private String email;
    private String image_url;
    @NotBlank(message = "required field")
    private String nom;
    @NotBlank(message = "required field")
    private String prenom;
    @NotNull(message = "required field")
    private String telephone;
    @NotBlank(message = "required field")
    /*@Pattern(regexp = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[#?!@$%^&*-])(?=\\S+$).{8,}",
            message = "your password must contain at least 8 characters including a caps,a lowercase ,a number and {#,?,!,@,$,%,^,&,*,-}" +
                    " and must not contain spaces")*/
    private String password;
    @NotBlank(message = "required field")
    private String discipline;
    @NotBlank(message = "required field")
    private String genre;

}
