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
    List<PensionResponse> getPensionsScolaire();
    PensionResponse getPensionScolaire(String matricule, String anneeAcademique);
    PensionResponse updatePensionScolaire(PensionRequest pension, String matricule, String anneeAcademique);
//    void deletePensionScolaire(String matricule);

}
