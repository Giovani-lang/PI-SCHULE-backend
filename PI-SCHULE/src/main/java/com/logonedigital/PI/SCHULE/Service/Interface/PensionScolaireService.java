package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.Administration;
import com.logonedigital.PI.SCHULE.Entity.PensionScolaire;
import com.logonedigital.PI.SCHULE.dto.pensionScolaire_dto.PensionRequest;

import java.util.List;

public interface PensionScolaireService {
    PensionScolaire addPensionScolaire(PensionRequest pensionScolaire);
    List<PensionScolaire> getPensionsScolaire();
    PensionScolaire getPensionScolaire(String nomElève);
   PensionScolaire updatePensionScolaire(PensionRequest pensionScolaire, String nomElève);
    void deletePensionScolaire(String nomElève);

}
