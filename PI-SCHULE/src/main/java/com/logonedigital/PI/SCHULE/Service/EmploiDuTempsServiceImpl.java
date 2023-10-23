package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.EmploiDuTemps;
import com.logonedigital.PI.SCHULE.Entity.Enseignant;
import com.logonedigital.PI.SCHULE.Entity.FicheDePresence;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Mapper.EmploiDuTempsMapper;
import com.logonedigital.PI.SCHULE.Repository.EmploiDuTempsRepository;
import com.logonedigital.PI.SCHULE.Repository.EnseignantRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.EmploiDuTempsService;
import com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto.EmploiDuTempsRequest;
import com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto.EmploiDuTempsResponse;
import com.logonedigital.PI.SCHULE.dto.ficheDePresence_dto.FicheDePresenceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class EmploiDuTempsServiceImpl implements EmploiDuTempsService {
    private final EmploiDuTempsRepository emploiDuTempsRepo;
    private final EmploiDuTempsMapper emploiDuTempsMapper;
    private final EnseignantRepository enseignantRepo;
    public EmploiDuTempsServiceImpl(EmploiDuTempsRepository emploiDuTempsRepo, EmploiDuTempsMapper emploiDuTempsMapper, EnseignantRepository enseignantRepo){
        this.emploiDuTempsRepo=emploiDuTempsRepo;
        this.emploiDuTempsMapper = emploiDuTempsMapper;
        this.enseignantRepo = enseignantRepo;
    }

    @Override
    public EmploiDuTempsResponse addEmploiDuTemps(EmploiDuTempsRequest emploiDuTemps) {
        EmploiDuTemps emploi = this.emploiDuTempsMapper.fromEmploiDuTempsRequest(emploiDuTemps);
        Enseignant ens = this.enseignantRepo.findByEmail(emploiDuTemps.getNomProf())
                .orElseThrow(()-> new RessourceNotFoundException("Enseignant with email doesn't exist"));
        emploi.setEnseignant(ens);
        return this.emploiDuTempsMapper.fromEmploiDuTemps(this.emploiDuTempsRepo.save(emploi));
    }

    @Override
    public List<EmploiDuTempsResponse> getEmploisDuTemps() {
        List<EmploiDuTemps> emploiDuTemps = this.emploiDuTempsRepo.findAll();
        List<EmploiDuTempsResponse> emploiDuTempsResponses = new ArrayList<>();
        emploiDuTemps.forEach(ficheDePresence -> emploiDuTempsResponses.add(this.emploiDuTempsMapper
                .fromEmploiDuTemps(ficheDePresence)));

        return emploiDuTempsResponses;
    }

    @Override
    public EmploiDuTempsResponse getEmploiDuTemps(Integer idClass) throws RessourceNotFoundException {
        try {

            return this.emploiDuTempsMapper.fromEmploiDuTemps(this.emploiDuTempsRepo.findById(idClass).get());
        } catch (Exception exception) {
            throw new RessourceNotFoundException("Doesn't exist");
        }
    }
    @Override
    public EmploiDuTempsResponse updateEmploiDuTemps(EmploiDuTempsRequest newEmploiDuTemps, Integer idClass) throws RessourceNotFoundException {

        try {


        EmploiDuTemps oldEmploiDuTemps = this.emploiDuTempsRepo.findById(idClass).get();

        oldEmploiDuTemps.setJours(newEmploiDuTemps.getJours());
        oldEmploiDuTemps.setHeure(newEmploiDuTemps.getHeure());
        log.error("OLd EmploiDuTemps{}", oldEmploiDuTemps);
        EmploiDuTemps emploiDuTempsUpdated = this.emploiDuTempsRepo.saveAndFlush(oldEmploiDuTemps);

        return this.emploiDuTempsMapper.fromEmploiDuTemps(emploiDuTempsUpdated);
    }catch (Exception exception) {
            throw new RessourceNotFoundException("Doesn't exist");
        }
    }

    @Override
    public void deleteEmploiDuTemps(Integer idClass) {
        try {
            EmploiDuTemps emploiDuTemps = this.emploiDuTempsRepo.findById(idClass).get();
            this.emploiDuTempsRepo.delete(emploiDuTemps);
        }catch (Exception ex){
            throw new RessourceNotFoundException("Doesn't exist");
        }

    }
}
