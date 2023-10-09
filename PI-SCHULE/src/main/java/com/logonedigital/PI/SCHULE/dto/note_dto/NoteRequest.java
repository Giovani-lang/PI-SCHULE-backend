package com.logonedigital.PI.SCHULE.dto.note_dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteRequest {
    @NotBlank(message = "required field")
    @Column(unique = true)
    private String nomMatiere;
    @Min(value = 2,message = "you can't enter a value above 2")
    @NotNull(message = "required field")
    private int coefficient;
    @Min(value = 0,message = "you can't enter a value above 0")
    @Max(value = 20,message = "you can't exceed 20")
    private float noteControle;
    @Min(value = 0,message = "you can't enter a value above 0")
    @Max(value = 20,message = "you can't exceed 20")
    private float noteSession;

}
