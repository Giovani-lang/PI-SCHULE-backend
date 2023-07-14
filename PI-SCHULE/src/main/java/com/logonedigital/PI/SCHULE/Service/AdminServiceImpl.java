package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Administration;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Repository.AdminRepo;
import com.logonedigital.PI.SCHULE.Service.Interface.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {
private final AdminRepo adminRepo;
public AdminServiceImpl(AdminRepo adminRepo){
    this.adminRepo=adminRepo;
}

    @Override
    public Administration addAdministration(Administration administration) {
        return this.adminRepo.save(administration);
    }

    @Override
    public List<Administration> getAdministrations() {
        return this.adminRepo.findAll();
    }

    @Override
    public Administration getAdministration(String email) throws RessourceNotFoundException{

    try { return this.adminRepo.findById(email).get();

    }catch (Exception exception){
        throw new RessourceNotFoundException("utlisateur n'existe pas");
    }

    }

    @Override
    public Administration updateAdministration(Administration newadministration, String email) throws RessourceNotFoundException {
    try {


        Administration oldAdministration = this.adminRepo.findById(email).get();


        oldAdministration.setNom(newadministration.getNom());
        oldAdministration.setPrenom(newadministration.getPrenom());
        oldAdministration.setPassword(newadministration.getPassword());
        log.error("Old user {}", oldAdministration);
        Administration administrationUpdated = this.adminRepo.save(oldAdministration);

        return administrationUpdated;
    }catch (Exception exception) {
        throw new RessourceNotFoundException("la mise à jour n'a pas été faite");
    }
    }

    @Override
    public void deleteAdministration(String email){

        this.adminRepo.deleteById(email);
    }




    }

