package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.Enseignant;


import java.util.List;

public interface IEnseignantService {
    Enseignant addEnseignant(Enseignant enseignant);
    Enseignant getEnseignant(String email);
    List<Enseignant> getEnseignants();
    Enseignant updateEnseignant(String email,Enseignant enseignant);
    void deleteAbsence(String email);
}
