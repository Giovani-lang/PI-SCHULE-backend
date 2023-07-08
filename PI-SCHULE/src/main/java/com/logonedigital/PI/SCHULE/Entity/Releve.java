package com.logonedigital.PI.SCHULE.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
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
    @Column(unique = true)
    private String module;

    @OneToMany(targetEntity = Note.class, mappedBy = "releve",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Note> noteList = new ArrayList<>();

    private String statut;


}
