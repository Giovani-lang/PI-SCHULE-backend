package com.logonedigital.PI.SCHULE.Mapper;

import com.logonedigital.PI.SCHULE.Entity.PensionScolaire;
import com.logonedigital.PI.SCHULE.dto.pensionScolaire_dto.PensionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Configuration;

@Mapper(componentModel = "spring")
@Configuration
public interface PensionMapper {
    PensionScolaire fromPensionRequest (PensionRequest pensionRequest);
}
