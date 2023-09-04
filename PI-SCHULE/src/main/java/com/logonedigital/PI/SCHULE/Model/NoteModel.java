package com.logonedigital.PI.SCHULE.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteModel {
    private String codeMatiere;
    private String nomMatiere;
    private int coefficient;
    private float noteSession;
    private float moyenne;
    private String statut;
}
