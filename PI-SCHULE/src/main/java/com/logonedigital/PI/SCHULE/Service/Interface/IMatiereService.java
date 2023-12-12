package com.logonedigital.PI.SCHULE.Service.Interface;


import com.logonedigital.PI.SCHULE.Entity.Matiere;

import java.util.List;

public interface IMatiereService {
    Matiere addMatiere (Matiere matiere);
    List<Matiere> getMatiere ();
    Matiere updateMatiere (String intitule,Matiere matiere);
    void deleteMatiere (String intitule);
}
