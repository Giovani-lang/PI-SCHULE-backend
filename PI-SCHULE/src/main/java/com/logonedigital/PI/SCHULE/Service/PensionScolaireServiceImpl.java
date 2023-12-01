package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Etudiant;
import com.logonedigital.PI.SCHULE.Entity.Paiement;
import com.logonedigital.PI.SCHULE.Entity.PensionScolaire;
import com.logonedigital.PI.SCHULE.Exception.RessourceExistException;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Mapper.PensionMapper;
import com.logonedigital.PI.SCHULE.Repository.EtudiantRepository;
import com.logonedigital.PI.SCHULE.Repository.PensionScolaireRepo;
import com.logonedigital.PI.SCHULE.Service.Interface.PensionScolaireService;
import com.logonedigital.PI.SCHULE.dto.pensionScolaire_dto.PensionRequest;
import com.logonedigital.PI.SCHULE.dto.pensionScolaire_dto.PensionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PensionScolaireServiceImpl implements PensionScolaireService {
    private final PensionScolaireRepo pensionScolaireRepo;
    private final PensionMapper pensionMapper;
    private final EtudiantRepository etudiantRepo;

    public PensionScolaireServiceImpl(PensionScolaireRepo pensionScolaireRepo, PensionMapper pensionMapper, EtudiantRepository etudiantRepo) {
        this.pensionScolaireRepo = pensionScolaireRepo;
        this.pensionMapper = pensionMapper;
        this.etudiantRepo = etudiantRepo;
    }




    @Override
    public PensionResponse addPensionScolaire(PensionRequest pensionScolaire) throws RessourceExistException {
       PensionScolaire pension = this.pensionMapper.fromPensionRequest(pensionScolaire);
        Etudiant etd = this.etudiantRepo.findByMatricule(pensionScolaire.getMatricule_etd())
                .orElseThrow(()-> new RessourceNotFoundException("Student with this matricule doesn't exist, try again !"));
        pension.setEtudiant(etd);
        return this.pensionMapper.fromPension(this.pensionScolaireRepo.save(pension));
    }

    @Override
    public List<PensionResponse> getPensionsScolaire() {
        List<PensionScolaire> pensionScolaire = this.pensionScolaireRepo.findAll();
        List<PensionResponse> pensionResponses = new ArrayList<>();
        pensionScolaire.forEach(pension->pensionResponses.add(this.pensionMapper
                .fromPension(pension)));
        return pensionResponses;
    }

    @Override
    public PensionResponse getPensionScolaire(String matricule) throws RessourceNotFoundException {
        try {

            /**** recherche de la pension avec le matricule de l'étudiant ******/
            PensionScolaire pensionScolaire = this.pensionScolaireRepo.findByMatricule(matricule).get();

            /**** somme des paiements au cours de l'année acadeémique correspondante ******/
            Double totalPaye = this.pensionScolaireRepo.getTotalPaymentForStudent(matricule);
            if (totalPaye == null){
                pensionScolaire.setTotalPaye(0.0);
            } else if (totalPaye != null) {
                pensionScolaire.setTotalPaye(totalPaye);
            }

            /**** mise à jour du total payé au cours de l'année  ******/
            this.pensionMapper.fromPension(this.pensionScolaireRepo.save(pensionScolaire));

            /**** affichage de la pension de l'étudiant ******/
            return this.pensionMapper.fromPension(this.pensionScolaireRepo.findByMatricule(matricule).get());
        }catch (Exception exception){
            throw new RessourceNotFoundException("utlisateur n'existe pas");
        }

    }

    @Override
    public PensionResponse updatePensionScolaire(PensionRequest newPensionScolaire, String matricule) throws RessourceNotFoundException {
        try {
            PensionScolaire oldPensionScolaire = this.pensionScolaireRepo.findByMatricule(matricule).get();


            oldPensionScolaire.setPensionAnnuelle(newPensionScolaire.getPensionAnnuelle());

            log.error("OLd PensionScolaire{}", oldPensionScolaire);


            PensionScolaire pensionScolaireUpdated = this.pensionScolaireRepo.save(oldPensionScolaire);

            return this.pensionMapper.fromPension(pensionScolaireUpdated);
        } catch (Exception exception) {
            throw new RessourceNotFoundException("la mise à jour n'a pas été faite");
        }
    }
    @Override
    public void deletePensionScolaire(String matricule) {
        PensionScolaire pensionScolaire = this.pensionScolaireRepo.findByMatricule(matricule).get();
        this.pensionScolaireRepo.delete(pensionScolaire);
    }

}

