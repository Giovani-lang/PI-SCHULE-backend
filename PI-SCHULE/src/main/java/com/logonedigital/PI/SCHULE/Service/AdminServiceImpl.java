package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Administration;
import com.logonedigital.PI.SCHULE.Exception.RessourceExistException;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Mapper.AdminMapper;
import com.logonedigital.PI.SCHULE.Repository.AdminRepo;
import com.logonedigital.PI.SCHULE.Service.Interface.AdminService;
import com.logonedigital.PI.SCHULE.dto.admin_dto.AdminRequestDTO;
import com.logonedigital.PI.SCHULE.dto.admin_dto.AdminResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepo adminRepo;
    private final AdminMapper adminMapper;

    @Override
    public AdminResponseDTO addAdministration(AdminRequestDTO adminRequestDTO) throws RessourceExistException {
        Administration admin = this.adminMapper.fromAdminRequestDTO(adminRequestDTO);
        Optional<Administration> userDB = this.adminRepo.findByEmail(adminRequestDTO.getEmail());
        Optional<Administration> user = this.adminRepo.findByTéléphone(adminRequestDTO.getTéléphone());
        if (userDB.isPresent()){
            throw new RessourceExistException("Admin with this email already exist !!!");
        } else if (user.isPresent()) {
            throw new RessourceExistException("Admin with this phone already exist !!!");
        }
        admin.setCreatedAt(new Date());
        return this.adminMapper.fromAdministration(this.adminRepo.save(admin));
    }

    @Override
    public List<AdminResponseDTO> getAdministrations() {
        List<Administration> admins= this.adminRepo.findAll();
        List<AdminResponseDTO> adminResponses = new ArrayList<>();
        admins.forEach(admin ->adminResponses.add(this.adminMapper.fromAdministration(admin)));
        return adminResponses;
    }

    @Override
    public AdminResponseDTO getAdministration(String email) throws RessourceNotFoundException{
        try {
            return this.adminMapper.fromAdministration(this.adminRepo.findByEmail(email).get());
        }catch (Exception ex){
            throw new RessourceNotFoundException("This email " +email+ " doesn't exist in our data base !");
        }
    }

    @Override
    public AdminResponseDTO updateAdministration(AdminRequestDTO adminRequestDTO, String email) throws RessourceNotFoundException {
        try {
            Administration admin1 = this.adminRepo.findByEmail(email).get();
            Administration admin = this.adminMapper.fromAdminRequestDTO(adminRequestDTO);
            admin1.setNom(admin.getNom());
            admin1.setPrenom(admin.getPrenom());
            admin1.setPassword(admin.getPassword());
            admin1.setTéléphone(admin.getTéléphone());

            return this.adminMapper.fromAdministration(this.adminRepo.save(admin1));
        }catch (Exception exception) {
            throw new RessourceNotFoundException("This email " +email+ " doesn't exist in our data base !");
        }
    }

    @Override
    public void deleteAdministration(String email) throws RessourceNotFoundException{
        try{
            Administration admin = this.adminRepo.findByEmail(email).get();
            this.adminRepo.delete(admin);
        }catch (Exception ex){
            throw new RessourceNotFoundException("This email " +email+ " doesn't exist in our data base !");
        }
    }

}

