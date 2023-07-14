package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Administration;
import com.logonedigital.PI.SCHULE.Entity.EmploiDuTemps;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Repository.AdminRepo;
import com.logonedigital.PI.SCHULE.Repository.EmploiDuTempsRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.EmploiDuTempsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class EmploiDuTempsServiceImpl implements EmploiDuTempsService {
    private final EmploiDuTempsRepository emploiDuTempsRepository;
    public EmploiDuTempsServiceImpl(EmploiDuTempsRepository emploiDuTempsRepository){
        this.emploiDuTempsRepository=emploiDuTempsRepository;
    }

    @Override
    public EmploiDuTemps addEmploiDuTemps(EmploiDuTemps emploiDuTemps) {
        return this.emploiDuTempsRepository.save(emploiDuTemps);
    }

    @Override
    public List<EmploiDuTemps> getEmploisDuTemps() {
        return this.emploiDuTempsRepository.findAll();
    }

    @Override
    public EmploiDuTemps getEmploiDuTemps(Integer idClass) throws RessourceNotFoundException {
        try {

            return this.emploiDuTempsRepository.findById(idClass).get();
        } catch (Exception exception) {
            throw new RessourceNotFoundException("n'existe pas");
        }
    }
    @Override
    public EmploiDuTemps updateEmploiDuTemps(EmploiDuTemps newEmploiDuTemps, Integer idClass) throws RessourceNotFoundException {

        try {


        EmploiDuTemps oldEmploiDuTemps = this.emploiDuTempsRepository.findById(idClass).get();


        oldEmploiDuTemps.setIdClass(newEmploiDuTemps.getIdClass());
        oldEmploiDuTemps.setJours(newEmploiDuTemps.getJours());
        oldEmploiDuTemps.setHeure(newEmploiDuTemps.getHeure());
        log.error("OLd EmploiDuTemps{}", oldEmploiDuTemps);
        EmploiDuTemps emploiDuTempsUpdated = this.emploiDuTempsRepository.save(oldEmploiDuTemps);

        return emploiDuTempsUpdated;
    }catch (Exception exception) {
            throw new RessourceNotFoundException("n'existe pas");
        }
    }

    @Override
    public void deleteEmploiDuTemps(Integer idClass) {
        this.emploiDuTempsRepository.deleteById(idClass);

    }
}
