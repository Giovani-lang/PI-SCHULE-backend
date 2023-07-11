package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Enseignant;
import com.logonedigital.PI.SCHULE.Exception.RessourceFoundException;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Repository.EnseignantRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.IEnseignantService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class EnseignantServiceImpl implements IEnseignantService {
    private final EnseignantRepository enseignantRepo;

    public EnseignantServiceImpl(EnseignantRepository enseignantRepo) {
        this.enseignantRepo = enseignantRepo;
    }

    @Override
    public Enseignant addEnseignant(Enseignant enseignant) throws RessourceFoundException {
        try {
            return this.enseignantRepo.save(enseignant);
        }catch (Exception ex){
            throw new RessourceFoundException("this enseignant already exists in our data base");
        }
    }

    @Override
    public Enseignant getEnseignant(String email)  throws RessourceNotFoundException {
        try {
            return this.enseignantRepo.findById(email).get();
        }catch (Exception ex){
            throw new RessourceNotFoundException("this email doesn't exist in our data base");
        }
    }

    @Override
    public List<Enseignant> getEnseigants() {
        return this.enseignantRepo.findAll();
    }

    @Override
    public Enseignant updateEnseignant(String email, Enseignant enseignant) throws RessourceNotFoundException {
        try {
            Enseignant newEnseignant = this.enseignantRepo.findById(email).get();

            newEnseignant.setEmail(enseignant.getEmail());
            newEnseignant.setNom(enseignant.getNom());
            newEnseignant.setPrenom(enseignant.getPrenom());
            newEnseignant.setNumeroTel(enseignant.getNumeroTel());
            newEnseignant.setMotDePasse(enseignant.getMotDePasse());
            newEnseignant.setDiscipline(enseignant.getDiscipline());

            return this.enseignantRepo.save(newEnseignant);
        }catch (Exception ex){
            throw new RessourceNotFoundException("this email doesn't exist in our data base");
        }
    }

    @Override
    public void deleteEnseignant(String email) throws RessourceNotFoundException{
       try {
           this.enseignantRepo.deleteById(email);
       }catch (Exception ex){
           throw new RessourceNotFoundException("this email doesn't exist in our data base");
       }
    }
}
