package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.FicheDePresence;
import com.logonedigital.PI.SCHULE.Exception.RessourceExistException;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Repository.FicheDePresenceRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.IFicheDePresenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class FicheDePresenceServiceImpl implements IFicheDePresenceService {
    private final FicheDePresenceRepository ficheDePresenceRepo;

    public FicheDePresenceServiceImpl(FicheDePresenceRepository ficheDePresenceRepo) {
        this.ficheDePresenceRepo = ficheDePresenceRepo;
    }

    @Override
    public FicheDePresence addFicheDePresence(FicheDePresence ficheDePresence) throws RessourceExistException {
        Optional<FicheDePresence> fich = this.ficheDePresenceRepo.findByMatricule(ficheDePresence.getMatricule());
        Optional<FicheDePresence> fich1 = this.ficheDePresenceRepo.findByNomComplet(ficheDePresence.getNomComplet());
        if (fich.isPresent()) {
            throw new RessourceExistException("A student with this matricule already exists");
        } else if (fich1.isPresent()) {
            throw new RessourceExistException("A student with this name already exists");
        }
        return this.ficheDePresenceRepo.save(ficheDePresence);
    }



    @Override
    public FicheDePresence getFicheDePresence(String matricule) throws RessourceNotFoundException {
        try {
            return this.ficheDePresenceRepo.findById(matricule).get();
        } catch (Exception ex) {
            throw new RessourceNotFoundException("this matricule doesn't exist in our data base");

        }
    }
    @Override
    public List<FicheDePresence> getFichesDePresence() {
        return this.ficheDePresenceRepo.findAll();
    }

    @Override
    public FicheDePresence updateFicheDePresence(String matricule, FicheDePresence ficheDePresence) {
        try {
            FicheDePresence newAbsence = this.ficheDePresenceRepo.findById(matricule).get();
            newAbsence.setDate(ficheDePresence.getDate());
            newAbsence.setNombreHeure(ficheDePresence.getNombreHeure());
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
