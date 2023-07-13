package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.Administration;
import com.logonedigital.PI.SCHULE.Entity.PensionScolaire;

import java.util.List;

public interface PensionScolaireService {
    PensionScolaire addPensionScolaire(PensionScolaire pensionScolaire);
    List<PensionScolaire> getPensionsScolaire();
    PensionScolaire getPensionScolaire(String nomElève);
   PensionScolaire updatePensionScolaire(PensionScolaire pensionScolaire, String nomElève);
    void deletePensionScolaire(String nomElève);

}
