package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.Enseignant;
import com.logonedigital.PI.SCHULE.Entity.FicheDePresence;
import com.logonedigital.PI.SCHULE.Exception.RessourceExistException;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.dto.ficheDePresence_dto.FicheDePresenceRequest;
import com.logonedigital.PI.SCHULE.dto.ficheDePresence_dto.FicheDePresenceResponse;

import java.util.List;

public interface IFicheDePresenceService {
    FicheDePresenceResponse addFicheDePresence(FicheDePresenceRequest ficheDePresence);

    FicheDePresenceResponse getFicheDePresence(String matricule);

    List<FicheDePresenceResponse> getFichesDePresence();

    FicheDePresenceResponse updateFicheDePresence(String matricule, FicheDePresenceRequest ficheDePresence);

    void deleteAbsence(String matricule);

}
