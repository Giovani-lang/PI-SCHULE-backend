package com.logonedigital.PI.SCHULE.Entity;


import jakarta.persistence.*;
import lombok.*;


import java.io.Serial;
import java.io.Serializable;

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
    private String nomMatiere;
    private int coefficient;
    private float noteControle;
    private float noteSession;
    private float moyenne;
    private String statut;



   public float getMoyenne() {
        float moyenneCC = this.noteControle* this.coefficient;
        float moyenneSN = this.noteSession*this.coefficient;
        int coefFinal = this.coefficient*2;
        moyenne = (moyenneCC+moyenneSN)/coefFinal;
        return moyenne;
    }

    public String getStatut(){
        if (moyenne>=10){
            return statut = "Validée";
        }return statut = "Non_Validée";
    }
}
