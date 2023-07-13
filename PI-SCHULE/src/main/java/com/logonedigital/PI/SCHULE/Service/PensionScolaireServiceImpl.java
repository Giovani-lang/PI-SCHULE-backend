package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Administration;
import com.logonedigital.PI.SCHULE.Entity.EmploiDuTemps;
import com.logonedigital.PI.SCHULE.Entity.PensionScolaire;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Repository.AdminRepo;
import com.logonedigital.PI.SCHULE.Repository.PensionScolaireRepo;
import com.logonedigital.PI.SCHULE.Service.Interface.PensionScolaireService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class PensionScolaireServiceImpl implements PensionScolaireService {
    private final PensionScolaireRepo pensionScolaireRepo;

    public PensionScolaireServiceImpl(PensionScolaireRepo pensionScolaireRepo) {
        this.pensionScolaireRepo = pensionScolaireRepo;

    }

    @Override
    public PensionScolaire addPensionScolaire(PensionScolaire pensionScolaire) {
       PensionScolaire pensionScolaire1=PensionScolaire.bill(
               pensionScolaire.getNomElève(),
               new Date(),
               pensionScolaire.getMontantPayé(),
               pensionScolaire.getSolde()

       );
        return this.pensionScolaireRepo.save(pensionScolaire1);
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
    public PensionScolaire updatePensionScolaire(PensionScolaire newPensionScolaire, String nomElève) throws RessourceNotFoundException {
        try {
            PensionScolaire oldPensionScolaire = this.pensionScolaireRepo.findById(nomElève).get();

            oldPensionScolaire.setNomElève(newPensionScolaire.getNomElève());
            oldPensionScolaire.setDateInscription(newPensionScolaire.getDateInscription());
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

