package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.AnneeAcademique;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Repository.AnneeAcademiqueRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.IAnneeAcademiqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnneeAcademiqueServiceImpl implements IAnneeAcademiqueService {
    private final AnneeAcademiqueRepository anneeAcademiqueRepo;
    @Override
    public AnneeAcademique addAnnee(AnneeAcademique anneeAcademique) {
        return this.anneeAcademiqueRepo.save(anneeAcademique);
    }

    @Override
    public AnneeAcademique getAnnee(String annee_academique) throws RessourceNotFoundException {
       try {
           return this.anneeAcademiqueRepo.findByAnnees(annee_academique).get();
       }catch (Exception ex){
           throw new RessourceNotFoundException("Doesn't exist !");
       }
    }

    @Override
    public List<AnneeAcademique> getAllAnnee() {
        return this.anneeAcademiqueRepo.findAll();
    }

    @Override
    public AnneeAcademique editAnnee(String annee_academique, AnneeAcademique anneeAcademique)throws RessourceNotFoundException {
       try {
           AnneeAcademique academique = this.anneeAcademiqueRepo.findByAnnees(annee_academique).get();
           academique.setAnnees(anneeAcademique.getAnnees());
           return this.anneeAcademiqueRepo.saveAndFlush(academique);
       }catch (Exception ex){
           throw new RessourceNotFoundException("Doesn't exist !");
       }
    }

    @Override
    public void deleteAnnee(String annee_academique)throws RessourceNotFoundException {
        Optional<AnneeAcademique> academique = this.anneeAcademiqueRepo.findByAnnees(annee_academique);
        this.anneeAcademiqueRepo.delete(academique.get());
        if (academique.isEmpty()){
            throw new RessourceNotFoundException("Doesn't exist !");
        }
    }
}
