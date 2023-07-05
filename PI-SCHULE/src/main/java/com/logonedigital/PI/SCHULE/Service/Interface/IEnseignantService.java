package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.Enseignant;

import java.util.List;

public interface IEnseignantService {
    Enseignant addEnseignant(Enseignant enseignant);
    Enseignant getEnseignant(String email);
    List<Enseignant> getAllEnseignant();
    Enseignant updateEnseignant(Enseignant enseignant, String email);
    void deleteEnseignant(String email);
}
