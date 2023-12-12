package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Matiere;
import com.logonedigital.PI.SCHULE.Repository.MatiereRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.IMatiereService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatiereServiceImpl implements IMatiereService {

    private final MatiereRepository matiereRepo;
    @Override
    public Matiere addMatiere(Matiere matiere) {
        return this.matiereRepo.save(matiere);
    }

    @Override
    public List<Matiere> getMatiere() {
        return this.matiereRepo.findAll();
    }

    @Override
    public Matiere updateMatiere(String intitule, Matiere matiere) {
        Matiere newMatiere = this.matiereRepo.findByIntitule(intitule).get();
        newMatiere.setCode(matiere.getCode());
        newMatiere.setCoefficient(matiere.getCoefficient());
        newMatiere.setIntitule(matiere.getIntitule());
        return this.matiereRepo.saveAndFlush(newMatiere);
    }

    @Override
    public void deleteMatiere(String intitule) {
        Matiere matiere = this.matiereRepo.findByIntitule(intitule).get();
        this.matiereRepo.delete(matiere);
    }
}
