package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.FicheDePresence;

import java.util.List;

public interface IFicheDePresenceService {
    FicheDePresence addAbsence(FicheDePresence absence);
    FicheDePresence getAbsence(String matricule);
    List<FicheDePresence> getAbsences();
    FicheDePresence updateAbscence(String matricule,FicheDePresence absence);
    void deleteAbsence(String matricule);
}
