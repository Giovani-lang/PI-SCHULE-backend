package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.Administration;
import com.logonedigital.PI.SCHULE.Entity.AnneeAcademique;
import com.logonedigital.PI.SCHULE.Entity.PensionScolaire;
import com.logonedigital.PI.SCHULE.Model.AnneeAcademiqueModel;
import com.logonedigital.PI.SCHULE.dto.pensionScolaire_dto.PensionRequest;
import com.logonedigital.PI.SCHULE.dto.pensionScolaire_dto.PensionResponse;

import java.util.List;

public interface PensionScolaireService {
    PensionResponse addPensionScolaire(PensionRequest pension);
    List<PensionResponse> getPensionsScolaire(Long annee);
    PensionResponse getPensionScolaire(String matricule, Long anneeAcademique);
    PensionResponse updatePensionScolaire(PensionRequest pension, String matricule, Long anneeAcademique);
//    void deletePensionScolaire(String matricule);

}
