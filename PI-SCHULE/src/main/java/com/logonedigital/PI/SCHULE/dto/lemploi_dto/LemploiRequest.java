package com.logonedigital.PI.SCHULE.dto.lemploi_dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LemploiRequest {

    @NotEmpty(message = "required field")
    private String Jour;
    @NotEmpty(message = "required field")
    private String debut;
    @NotNull(message = "required field")
    private int duree;
    @NotEmpty(message = "required field")
    private String cours;
    @NotEmpty(message = "required field")
    private String email_enseignant;
    @NotEmpty(message = "required field")
    private String nom_classe;
}
