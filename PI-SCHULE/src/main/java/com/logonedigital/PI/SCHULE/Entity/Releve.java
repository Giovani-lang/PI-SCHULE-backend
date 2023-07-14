package com.logonedigital.PI.SCHULE.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.logonedigital.PI.SCHULE.Enumeration.StatutName;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_releves")
@Entity
public class Releve implements Serializable {
    @Serial
    private static final Long serialVersionUID = 1L;
    @Id
    @NotNull(message = "invalid, try again")
    @NotBlank(message = "required field")
    private String module;
    @OneToMany(mappedBy = "moduleReleve",targetEntity = Note.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Note> noteList = new ArrayList<>();

    @Enumerated
    private StatutName statut;



}
