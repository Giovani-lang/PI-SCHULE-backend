package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.AnneeAcademique;
import com.logonedigital.PI.SCHULE.Entity.Classe;
import com.logonedigital.PI.SCHULE.Entity.EmploiDuTemps;
import com.logonedigital.PI.SCHULE.Entity.Enseignant;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Mapper.EmploiDuTempsMapper;
import com.logonedigital.PI.SCHULE.Repository.AnneeAcademiqueRepository;
import com.logonedigital.PI.SCHULE.Repository.ClasseRepository;
import com.logonedigital.PI.SCHULE.Repository.EmploiDuTempsRepository;
import com.logonedigital.PI.SCHULE.Repository.EnseignantRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.IEmploiDuTempsService;
import com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto.EmploiDuTempsRequest;
import com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto.EmploiDuTempsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class EmploiDuTempsServiceImpl implements IEmploiDuTempsService {
    private final EmploiDuTempsRepository emploiDuTempsRepo;
    private final EmploiDuTempsMapper emploiDuTempsMapper;
    private final AnneeAcademiqueRepository anneeAcademiqueRepo;
    private final ClasseRepository classeRepo;
    @Override
    public EmploiDuTempsResponse addEmploiDuTemps(EmploiDuTempsRequest emploiDuTemps) {
        EmploiDuTemps emploi = this.emploiDuTempsMapper.fromEmploiDuTempsRequest(emploiDuTemps);
        AnneeAcademique anneeAcademique = this.anneeAcademiqueRepo.findByAnnees(emploiDuTemps.getAnnee_academique())
                .orElseThrow(()-> new RessourceNotFoundException("Impossible year "+emploiDuTemps.getAnnee_academique()+" doesn't exist, try again !"));
        emploi.setAnnee(anneeAcademique);
        Classe classe = this.classeRepo.findByNom(emploiDuTemps.getNom_classe())
                .orElseThrow(()-> new RessourceNotFoundException("Classe"+emploiDuTemps.getNom_classe()+"doesn't exsit"));
        emploi.setClasse(classe);
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
    public EmploiDuTempsResponse getEmploiDuTemps(String classe) throws RessourceNotFoundException {
        try {

            return this.emploiDuTempsMapper.fromEmploiDuTemps(this.emploiDuTempsRepo.findByClasse(classe).get());
        } catch (Exception exception) {
            throw new RessourceNotFoundException("Doesn't exist");
        }
    }
    @Override
    public EmploiDuTempsResponse updateEmploiDuTemps(EmploiDuTempsRequest newEmploiDuTemps, String classe) throws RessourceNotFoundException {
        try {
        EmploiDuTemps oldEmploiDuTemps = this.emploiDuTempsRepo.findByClasse(classe).get();
        EmploiDuTemps emploiDuTemps = this.emploiDuTempsMapper.fromEmploiDuTempsRequest(newEmploiDuTemps);
        oldEmploiDuTemps.setAnnee(emploiDuTemps.getAnnee());
        oldEmploiDuTemps.setClasse(emploiDuTemps.getClasse());
        oldEmploiDuTemps.setSemestre(emploiDuTemps.getSemestre());
        log.error("OLd EmploiDuTemps{}", oldEmploiDuTemps);
        EmploiDuTemps emploiDuTempsUpdated = this.emploiDuTempsRepo.saveAndFlush(oldEmploiDuTemps);

        return this.emploiDuTempsMapper.fromEmploiDuTemps(emploiDuTempsUpdated);
    }catch (Exception exception) {
            throw new RessourceNotFoundException("Doesn't exist");
        }
    }

    @Override
    public void deleteEmploiDuTemps(String classe) {
        try {
            EmploiDuTemps emploiDuTemps = this.emploiDuTempsRepo.findByClasse(classe).get();
            this.emploiDuTempsRepo.delete(emploiDuTemps);
        }catch (Exception ex){
            throw new RessourceNotFoundException("Doesn't exist");
        }

    }
}
