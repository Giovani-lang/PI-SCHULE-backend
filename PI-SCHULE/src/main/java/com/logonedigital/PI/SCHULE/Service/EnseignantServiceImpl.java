package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Enseignant;
import com.logonedigital.PI.SCHULE.Exception.RessourceFoundException;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Repository.EnseignantRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.IEnseignantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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
            throw new RessourceFoundException("A enseignant with that name already exists");
        }
    }

    @Override
    public Enseignant getEnseignant(String email) throws RessourceNotFoundException {
        try {
            return this.enseignantRepo.findByEmail(email);
        }catch (Exception ex){
            throw new RessourceNotFoundException("this email : " +email+" doesn't exist in our data base");
        }
    }

    @Override
    public List<Enseignant> getEnseignants() {
        return this.enseignantRepo.findAll();
    }

    @Override
    public Enseignant updateEnseignant(String email, Enseignant enseignant) throws RessourceNotFoundException {
        try {
            Enseignant newEnseignant = this.enseignantRepo.findByEmail(email);
            newEnseignant.setEmail(enseignant.getEmail());
            newEnseignant.setNom(enseignant.getNom());
            newEnseignant.setPrenom(enseignant.getPrenom());
            newEnseignant.setNumeroTel(enseignant.getNumeroTel());
            newEnseignant.setMotDePasse(enseignant.getMotDePasse());
            newEnseignant.setDiscipline(enseignant.getDiscipline());
            return this.enseignantRepo.save(newEnseignant);
        }catch (Exception ex){
            throw new RessourceNotFoundException("this email : " +email+" doesn't exist in our data base");
        }
    }

    @Override
    public void deleteAbsence(String email) throws RessourceNotFoundException {
            try {
                this.enseignantRepo.deleteById(email);
            }catch (Exception ex){
                throw new RessourceNotFoundException("this email : " +email+" doesn't exist in our data base");
            }
    }
}
