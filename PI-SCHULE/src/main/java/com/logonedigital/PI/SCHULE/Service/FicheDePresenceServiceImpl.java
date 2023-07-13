package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.FicheDePresence;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Repository.FicheDePresenceRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.IFicheDePresenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class FicheDePresenceServiceImpl implements IFicheDePresenceService {
    private final FicheDePresenceRepository ficheDePresenceRepo;

    public FicheDePresenceServiceImpl(FicheDePresenceRepository ficheDePresenceRepo) {
        this.ficheDePresenceRepo = ficheDePresenceRepo;
    }

    @Override
    public FicheDePresence addAbsence(FicheDePresence absence) {
        FicheDePresence ficheDePresence = FicheDePresence.build(
                absence.getMatricule(),
                new Date(),
                absence.getNomComplet(),
                absence.getNombreHeure()
        );
        return this.ficheDePresenceRepo.save(ficheDePresence);
    }

    @Override
    public FicheDePresence getAbsence(String matricule) throws RessourceNotFoundException {
        try {
            return this.ficheDePresenceRepo.findById(matricule).get();
        }catch (Exception ex){
            throw new RessourceNotFoundException("this matricule doesn't exist in our data base");
        }
    }

    @Override
    public List<FicheDePresence> getAbsences() {
        return this.ficheDePresenceRepo.findAll();
    }

    @Override
    public FicheDePresence updateAbscence(String matricule, FicheDePresence absence) throws RessourceNotFoundException{
        try {
            FicheDePresence newAbsence = this.ficheDePresenceRepo.findById(matricule).get();
            newAbsence.setDate(absence.getDate());
            newAbsence.setNombreHeure(absence.getNombreHeure());
            return this.ficheDePresenceRepo.save(newAbsence);
        }catch (Exception ex){
            throw new RessourceNotFoundException("this matricule doesn't exist in our data base");
        }
    }

    @Override
    public void deleteAbsence(String matricule) throws RessourceNotFoundException{
        try {
            this.ficheDePresenceRepo.deleteById(matricule);
        }catch (Exception ex){
            throw new RessourceNotFoundException("this matricule doesn't exist in our data base");
        }
    }
}
