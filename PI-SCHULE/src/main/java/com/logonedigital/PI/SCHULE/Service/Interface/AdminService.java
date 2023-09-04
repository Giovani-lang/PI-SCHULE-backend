package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.Administration;
import com.logonedigital.PI.SCHULE.dto.admin_dto.AdminRequestDTO;
import com.logonedigital.PI.SCHULE.dto.admin_dto.AdminResponseDTO;

import java.util.List;

public interface AdminService {
    AdminResponseDTO addAdministration(AdminRequestDTO adminRequestDTO);
    List<AdminResponseDTO> getAdministrations();
    AdminResponseDTO getAdministration(String email);
    AdminResponseDTO updateAdministration(AdminRequestDTO adminRequestDTO, String email);
    void deleteAdministration(String email);

}
