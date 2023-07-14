package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Enseignant;
import com.logonedigital.PI.SCHULE.Exception.ResourceExistException;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Repository.EnseignantRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.IEnseignantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EnseignantServiceImpl implements IEnseignantService {

    private final EnseignantRepository enseignantRepo;

    public EnseignantServiceImpl(EnseignantRepository enseignantRepo) {
        this.enseignantRepo = enseignantRepo;
    }

    @Override
    public Enseignant addEnseignant(Enseignant enseignant) throws ResourceExistException {
        Optional<Enseignant> ens = this.enseignantRepo.findByEmail(enseignant.getEmail());
        Optional<Enseignant> ens1 = this.enseignantRepo.findByMotDePasse(enseignant.getMotDePasse());
        Optional<Enseignant> ens2 = this.enseignantRepo.findByNumeroTel(enseignant.getNumeroTel());
        if (ens.isPresent()){
            throw new ResourceExistException("A enseignant with this email already exists");
        } else if (ens1.isPresent()) {
            throw new ResourceExistException("A enseignant with this password already exists");
        } else if (ens2.isPresent()) {
            throw new ResourceExistException("A enseignant with this number phone already exists");
        }
        return this.enseignantRepo.save(enseignant);
    }

    @Override
    public Enseignant getEnseignant(String email) throws RessourceNotFoundException {
        try {
            return this.enseignantRepo.findById(email).get();
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
            Enseignant newEnseignant = this.enseignantRepo.findById(email).get();
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
