package com.logonedigital.PI.SCHULE.Mapper;

import com.logonedigital.PI.SCHULE.Entity.Administration;
import com.logonedigital.PI.SCHULE.Entity.EmploiDuTemps;
import com.logonedigital.PI.SCHULE.Entity.PensionScolaire;
import com.logonedigital.PI.SCHULE.dto.admin_dto.AdminRequestDTO;
import com.logonedigital.PI.SCHULE.dto.admin_dto.AdminResponseDTO;
import com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto.EmploiDuTempsRequest;
import com.logonedigital.PI.SCHULE.dto.pensionScolaire_dto.PensionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Mapper(componentModel = "spring")
@Configuration
public interface AdminMapper {

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);
    Administration fromAdminRequestDTO(AdminRequestDTO adminRequestDTO);
    List<EmploiDuTemps> fromEmploiDuTempsRequest (List<EmploiDuTempsRequest> emploiDuTempsRequest);
    List<PensionScolaire> fromPensionRequest (List<PensionRequest> pensionRequests);

    @Mapping(target = "emploiDuTemps", source = "emploisDuTemps")
    @Mapping(target = "pensions", source = "pensionScolaires")
    AdminResponseDTO fromAdministration(Administration administration);
}
