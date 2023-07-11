package com.logonedigital.PI.SCHULE.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "tb_notes")
@Entity
public class Note  implements Serializable {
    @Serial
    private static final Long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String codeMatiere;
    @Column(unique = true)
    @NotBlank(message = "required field")
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
    @Min(value = 0,message = "you can't enter a value above 0")
    @Max(value = 20,message = "you can't exceed 20")

    private float moyenne;

    @ManyToOne(targetEntity = Releve.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Releve releve;

}
