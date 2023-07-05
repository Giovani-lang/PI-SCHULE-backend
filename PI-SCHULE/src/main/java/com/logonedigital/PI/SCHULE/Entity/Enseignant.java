package com.logonedigital.PI.SCHULE.Entity;

import jakarta.persistence.*;
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
@Table(name = "tb_enseignants")
@PrimaryKeyJoinColumn(name = "id")
@Entity
public class Enseignant implements Serializable {
    @Serial
    private static final Long serialVersionUID = 1L;
    @Id
    private Long id;
    @NotNull
    private String discipline;
}
