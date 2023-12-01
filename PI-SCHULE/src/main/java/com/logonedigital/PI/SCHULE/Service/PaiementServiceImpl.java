package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Etudiant;
import com.logonedigital.PI.SCHULE.Entity.Paiement;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Mapper.PaiementMapper;
import com.logonedigital.PI.SCHULE.Repository.EtudiantRepository;
import com.logonedigital.PI.SCHULE.Repository.PaiementRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.IPaiementService;
import com.logonedigital.PI.SCHULE.dto.paiement_dto.PaiementRequest;
import com.logonedigital.PI.SCHULE.dto.paiement_dto.PaiementResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements IPaiementService {
    private final PaiementRepository paiementRepo;
    private final PaiementMapper paiementMapper;
    private final EtudiantRepository etudiantRepo;
    @Override
    public PaiementResponse addPaiement(PaiementRequest paiementRequest) {
        Paiement paiement = this.paiementMapper.fromPaiementRequest(paiementRequest);
        Etudiant etd = this.etudiantRepo.findByMatricule(paiementRequest.getMatricule_etd())
                .orElseThrow(()-> new RessourceNotFoundException("Student with this matricule doesn't exist, try again !"));
        paiement.setEtudiant(etd);
        paiement.setDate(new Date());
        return this.paiementMapper.fromPaiement(this.paiementRepo.save(paiement));
    }

    @Override
    public PaiementResponse getPaiement(Long id) throws RessourceNotFoundException{
      try {
          return this.paiementMapper.fromPaiement(this.paiementRepo.findById(id).get());
      }catch (Exception ex){
          throw new RessourceNotFoundException("No payment matches this id");
      }
    }

    @Override
    public List<PaiementResponse> getAllPaiement() {
        List<Paiement> paiements = this.paiementRepo.findAll();
        List<PaiementResponse> paiementResponses = new ArrayList<>();
        paiements.forEach(paiement -> paiementResponses.add(this.paiementMapper.fromPaiement(paiement)));
        return paiementResponses;
    }

    @Override
    public PaiementResponse editPaiement(Long id, PaiementRequest paiementRequest) throws RessourceNotFoundException {
        try {
            Paiement paiement = this.paiementRepo.findById(id).get();

            paiement.setMontant(paiementRequest.getMontant());
            paiement.setLibelle(paiementRequest.getLibelle());
            return this.paiementMapper.fromPaiement(this.paiementRepo.saveAndFlush(paiement));
        }catch (Exception ex){
            throw new RessourceNotFoundException("No payment matches this id");
        }
    }

    @Override
    public void deletePaiement(Long id) {
        this.paiementRepo.deleteById(id);
    }
}
