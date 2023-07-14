package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.FicheDePresence;

import java.util.List;

public interface IFicheDePresenceService {
    FicheDePresence addFicheDePresence(FicheDePresence ficheDePresence);

    FicheDePresence getFicheDePresence(String matricule);

    List<FicheDePresence> getFichesDePresence();

    FicheDePresence updateFicheDePresence(String matricule, FicheDePresence ficheDePresence);

    void deleteAbsence(String matricule);

}
