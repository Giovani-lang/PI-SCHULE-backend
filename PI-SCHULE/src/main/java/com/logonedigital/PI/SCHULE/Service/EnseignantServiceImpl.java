package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Enseignant;
import com.logonedigital.PI.SCHULE.Repository.EnseignantRepo;
import com.logonedigital.PI.SCHULE.Service.Interface.IEnseignantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantServiceImpl implements IEnseignantService {
    private final EnseignantRepo enseignantRepo;

    public EnseignantServiceImpl(EnseignantRepo enseignantRepo) {
        this.enseignantRepo = enseignantRepo;
    }

    @Override
    public Enseignant addEnseignant(Enseignant enseignant) {
        return this.enseignantRepo.save(enseignant);
    }

    @Override
    public Enseignant getEnseignant(String email) {
        return this.enseignantRepo.findById(email).get();
    }

    @Override
    public List<Enseignant> getAllEnseignant() {
        return this.enseignantRepo.findAll();
    }

    @Override
    public Enseignant updateEnseignant(Enseignant enseignant, String email) {
        Enseignant newEnseignant = this.enseignantRepo.findById(email).get();
        newEnseignant.setEmail(enseignant.getEmail());
        newEnseignant.setNom(enseignant.getNom());
        newEnseignant.setPrenom(enseignant.getPrenom());
        newEnseignant.setMotDePasse(enseignant.getMotDePasse());
        newEnseignant.setNumeroTel(enseignant.getNumeroTel());
        newEnseignant.setDiscipline(enseignant.getDiscipline());
        return this.enseignantRepo.save(newEnseignant);
    }

    @Override
    public void deleteEnseignant(String email) {
        this.enseignantRepo.deleteById(email);
    }
}
