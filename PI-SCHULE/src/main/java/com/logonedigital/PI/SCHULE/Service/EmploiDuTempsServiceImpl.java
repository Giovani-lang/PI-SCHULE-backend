package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.EmploiDuTemps;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Mapper.EmploiDuTempsMapper;
import com.logonedigital.PI.SCHULE.Repository.EmploiDuTempsRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.EmploiDuTempsService;
import com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto.EmploiDuTempsRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class EmploiDuTempsServiceImpl implements EmploiDuTempsService {
    private final EmploiDuTempsRepository emploiDuTempsRepository;
    private final EmploiDuTempsMapper emploiDuTempsMapper;
    public EmploiDuTempsServiceImpl(EmploiDuTempsRepository emploiDuTempsRepository, EmploiDuTempsMapper emploiDuTempsMapper){
        this.emploiDuTempsRepository=emploiDuTempsRepository;
        this.emploiDuTempsMapper = emploiDuTempsMapper;
    }

    @Override
    public EmploiDuTemps addEmploiDuTemps(EmploiDuTempsRequest emploiDuTemps) {
        EmploiDuTemps emploi = this.emploiDuTempsMapper.fromEmploiDuTempsRequest(emploiDuTemps);
        return this.emploiDuTempsRepository.save(emploi);
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
    public EmploiDuTemps updateEmploiDuTemps(EmploiDuTempsRequest newEmploiDuTemps, Integer idClass) throws RessourceNotFoundException {

        try {


        EmploiDuTemps oldEmploiDuTemps = this.emploiDuTempsRepository.findById(idClass).get();

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
