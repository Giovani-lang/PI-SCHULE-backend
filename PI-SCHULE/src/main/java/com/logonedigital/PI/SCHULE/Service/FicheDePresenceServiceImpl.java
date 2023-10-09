package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Enseignant;
import com.logonedigital.PI.SCHULE.Entity.Etudiant;
import com.logonedigital.PI.SCHULE.Entity.FicheDePresence;
import com.logonedigital.PI.SCHULE.Exception.RessourceExistException;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Mapper.FicheDePresenceMapper;
import com.logonedigital.PI.SCHULE.Repository.EnseignantRepository;
import com.logonedigital.PI.SCHULE.Repository.EtudiantRepository;
import com.logonedigital.PI.SCHULE.Repository.FicheDePresenceRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.IFicheDePresenceService;
import com.logonedigital.PI.SCHULE.dto.ficheDePresence_dto.FicheDePresenceRequest;
import com.logonedigital.PI.SCHULE.dto.ficheDePresence_dto.FicheDePresenceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class FicheDePresenceServiceImpl implements IFicheDePresenceService {
    private final FicheDePresenceRepository ficheDePresenceRepo;
    private final FicheDePresenceMapper ficheDePresenceMapper;
    private final EnseignantRepository enseignantRepo;
    private final EtudiantRepository etudiantRepo;

    public FicheDePresenceServiceImpl(FicheDePresenceRepository ficheDePresenceRepo, FicheDePresenceMapper ficheDePresenceMapper, EnseignantRepository enseignantRepo, EtudiantRepository etudiantRepo) {
        this.ficheDePresenceRepo = ficheDePresenceRepo;
        this.ficheDePresenceMapper = ficheDePresenceMapper;
        this.enseignantRepo = enseignantRepo;
        this.etudiantRepo = etudiantRepo;
    }

    @Override
    public FicheDePresenceResponse addFicheDePresence(FicheDePresenceRequest ficheDePresence) throws RessourceExistException {
        FicheDePresence fiche = this.ficheDePresenceMapper.fromFicheDePresenceResquest(ficheDePresence);
        Enseignant ens = this.enseignantRepo.findByEmail(ficheDePresence.getNomEnseignant())
                .orElseThrow(()-> new RessourceNotFoundException("Enseignant with email doesn't exist"));
        fiche.setEnseignant(ens);
        fiche.setDate(new Date());
        return this.ficheDePresenceMapper.fromFicheDePresence(this.ficheDePresenceRepo.save(fiche));
    }



    @Override
    public FicheDePresenceResponse getFicheDePresence(String matricule) throws RessourceNotFoundException {
        try {
            return this.ficheDePresenceMapper.fromFicheDePresence(this.ficheDePresenceRepo.findById(matricule).get());
        } catch (Exception ex) {
            throw new RessourceNotFoundException("this matricule doesn't exist in our data base");

        }
    }
    @Override
    public List<FicheDePresenceResponse> getFichesDePresence() {
        List<FicheDePresence> fiches = this.ficheDePresenceRepo.findAll();
        List<FicheDePresenceResponse> ficheResponses = new ArrayList<>();
        fiches.forEach(ficheDePresence -> ficheResponses.add(this.ficheDePresenceMapper
                .fromFicheDePresence(ficheDePresence)));

        return ficheResponses;
    }

    @Override
    public FicheDePresenceResponse updateFicheDePresence(String matricule, FicheDePresenceRequest ficheDePresence) {
        try {
            FicheDePresence newAbsence = this.ficheDePresenceRepo.findById(matricule).get();

            newAbsence.setNomComplet(ficheDePresence.getNomComplet());
            newAbsence.setNombreHeure(ficheDePresence.getNombreHeure());
            return this.ficheDePresenceMapper.fromFicheDePresence(this.ficheDePresenceRepo
                    .saveAndFlush(newAbsence));
        }catch (Exception ex){
            throw new RessourceNotFoundException("this matricule doesn't exist in our data base");
        }
    }
    @Override
    public void deleteAbsence(String matricule) throws RessourceNotFoundException{
        try {
            FicheDePresence fiche = this.ficheDePresenceRepo.findById(matricule).get();
            this.ficheDePresenceRepo.delete(fiche);
        }catch (Exception ex){
            throw new RessourceNotFoundException("this matricule doesn't exist in our data base");
        }
    }

}
