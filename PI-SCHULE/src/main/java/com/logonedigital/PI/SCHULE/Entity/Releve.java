package com.logonedigital.PI.SCHULE.Entity;


import com.logonedigital.PI.SCHULE.Enumeration.DecisionName;
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
@AllArgsConstructor(staticName = "build")
@Table(name = "tb_releves")
@Entity
public class Releve implements Serializable {
    @Serial
    private static final Long serialVersionUID = 1L;
    @Id
    @NotNull(message = "invalid, try again")
    @NotBlank(message = "required field")
    private String module;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Note> noteList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private DecisionName decision;



}
