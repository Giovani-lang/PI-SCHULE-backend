package com.logonedigital.PI.SCHULE.Mapper;

import com.logonedigital.PI.SCHULE.Entity.EmploiDuTemps;
import com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto.EmploiDuTempsRequest;
import com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto.EmploiDuTempsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Configuration;

@Mapper(componentModel = "spring")
@Configuration
public interface EmploiDuTempsMapper {
    EmploiDuTemps fromEmploiDuTempsRequest(EmploiDuTempsRequest emploiDuTempsRequest);

    @Mapping(target = "enseignant", source = "enseignant")
    EmploiDuTempsResponse fromEmploiDuTemps(EmploiDuTemps emploiDuTemps);
}
