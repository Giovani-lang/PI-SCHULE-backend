package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.PensionScolaire;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Mapper.PensionMapper;
import com.logonedigital.PI.SCHULE.Repository.PensionScolaireRepo;
import com.logonedigital.PI.SCHULE.Service.Interface.PensionScolaireService;
import com.logonedigital.PI.SCHULE.dto.pensionScolaire_dto.PensionRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class PensionScolaireServiceImpl implements PensionScolaireService {
    private final PensionScolaireRepo pensionScolaireRepo;
    private final PensionMapper pensionMapper;

    public PensionScolaireServiceImpl(PensionScolaireRepo pensionScolaireRepo, PensionMapper pensionMapper) {
        this.pensionScolaireRepo = pensionScolaireRepo;
        this.pensionMapper = pensionMapper;
    }

    @Override
    public PensionScolaire addPensionScolaire(PensionRequest pensionScolaire) {
       PensionScolaire pension = this.pensionMapper.fromPensionRequest(pensionScolaire);
       pension.setDateInscription(new Date());
        return this.pensionScolaireRepo.save(pension);
    }

    @Override
    public List<PensionScolaire> getPensionsScolaire() {
        return this.pensionScolaireRepo.findAll();
    }

    @Override
    public PensionScolaire getPensionScolaire(String nomElève) throws RessourceNotFoundException {
        try { return this.pensionScolaireRepo.findById(nomElève).get();

        }catch (Exception exception){
            throw new RessourceNotFoundException("utlisateur n'existe pas");
        }

    }

    @Override
    public PensionScolaire updatePensionScolaire(PensionRequest newPensionScolaire, String nomElève) throws RessourceNotFoundException {
        try {
            PensionScolaire oldPensionScolaire = this.pensionScolaireRepo.findById(nomElève).get();

            oldPensionScolaire.setNomElève(newPensionScolaire.getNomElève());
            oldPensionScolaire.setMontantPayé(newPensionScolaire.getMontantPayé());
            oldPensionScolaire.setSolde(newPensionScolaire.getSolde());

            log.error("OLd PensionScolaire{}", oldPensionScolaire);


            PensionScolaire pensionScolaireUpdated = this.pensionScolaireRepo.save(oldPensionScolaire);

            return pensionScolaireUpdated;
        } catch (Exception exception) {
            throw new RessourceNotFoundException("la mise à jour n'a pas été faite");
        }
    }
    @Override
    public void deletePensionScolaire(String nomElève) {
        this.pensionScolaireRepo.deleteById(nomElève);
    }

}

