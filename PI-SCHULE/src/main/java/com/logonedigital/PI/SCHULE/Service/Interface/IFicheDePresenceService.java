package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.Enseignant;
import com.logonedigital.PI.SCHULE.Entity.FicheDePresence;
import com.logonedigital.PI.SCHULE.Exception.RessourceExistException;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;

import java.util.List;

public interface IFicheDePresenceService {
    FicheDePresence addFicheDePresence(FicheDePresence ficheDePresence);

    FicheDePresence getFicheDePresence(String matricule);

    List<FicheDePresence> getFichesDePresence();

    FicheDePresence updateFicheDePresence(String matricule, FicheDePresence ficheDePresence);

    void deleteAbsence(String matricule);

}
