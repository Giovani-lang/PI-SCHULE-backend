package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Administration;
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
    public Administration getAdministration(Integer id) {
        return this.adminRepo.findById(id).get();
    }

    @Override
    public Administration updateAdministration(Administration newadministration, Integer id) {

        Administration oldAdministration = this.adminRepo.findById(id).get();


        oldAdministration.setNom(newadministration.getNom());
        oldAdministration.setPrenom(newadministration.getPrenom());
        oldAdministration.setPassword(newadministration.getPassword());
        log.error("Old user {}", oldAdministration);
        Administration administrationUpdated = this.adminRepo.save(oldAdministration);

        return administrationUpdated;
    }

    @Override
    public void deleteAdministration(Integer id) {

    }
}
