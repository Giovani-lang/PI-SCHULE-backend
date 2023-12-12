package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.Filiere;

import java.util.List;

public interface IFiliereService {
    Filiere addFiliere (Filiere filiere);
    List<Filiere> getFiliere ();

    Filiere getByName(String nom);
    Filiere updateFiliere (String nom,Filiere filiere);
    void deleteFiliere (String nom);

}
