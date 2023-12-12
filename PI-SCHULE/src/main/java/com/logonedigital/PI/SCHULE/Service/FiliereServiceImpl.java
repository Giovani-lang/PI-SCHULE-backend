package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Filiere;
import com.logonedigital.PI.SCHULE.Repository.FiliereRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.IFiliereService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FiliereServiceImpl implements IFiliereService {

    private final FiliereRepository filiereRepo;
    @Override
    public Filiere addFiliere(Filiere filiere) {
        return this.filiereRepo.save(filiere);
    }

    @Override
    public List<Filiere> getFiliere() {
        return this.filiereRepo.findAll();
    }

    @Override
    public Filiere getByName(String nom) {
        return this.filiereRepo.findByNom(nom).get();
    }

    @Override
    public Filiere updateFiliere(String nom, Filiere filiere) {
        Filiere newFiliere = this.filiereRepo.findByNom(nom).get();
        newFiliere.setNom(filiere.getNom());
        return this.filiereRepo.saveAndFlush(newFiliere);
    }

    @Override
    public void deleteFiliere(String nom) {
        Filiere filiere = this.filiereRepo.findByNom(nom).get();
        this.filiereRepo.delete(filiere);
    }
}
