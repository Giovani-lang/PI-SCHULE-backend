package com.logonedigital.PI.SCHULE.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


import java.io.Serial;
import java.io.Serializable;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Table(name = "tb_notes")
@ToString
@Entity
public class Note  implements Serializable {
    @Serial
    private static final Long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String codeMatiere;
    @NotBlank(message = "required field")
    @NotNull(message = "invalid, try again")
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
    @Min(value = 0,message = "you can't enter a value above 0")
    @Max(value = 20,message = "you can't exceed 20")
    private float moyenne;
    @JsonIgnore
    @ManyToOne(targetEntity = Releve.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Releve moduleReleve;







    public float getMoyenne(float noteControle,float noteSession, int coefficient) {
        float moyenneCC = this.noteControle* this.coefficient;
        float moyenneSN = this.noteSession*this.coefficient;
        int coefFinal = this.coefficient*2;
        moyenne = (moyenneCC+moyenneSN)/coefFinal;

            return moyenne;
    }
}
