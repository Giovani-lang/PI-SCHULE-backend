package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.AnneeAcademique;

import java.util.List;

public interface IAnneeAcademiqueService {

    AnneeAcademique addAnnee (AnneeAcademique anneeAcademique);
    AnneeAcademique getAnnee(String annee_academique);
    List<AnneeAcademique> getAllAnnee();
    AnneeAcademique editAnnee(String annee_academique, AnneeAcademique anneeAcademique);
    void deleteAnnee(String annee_academique);
}
