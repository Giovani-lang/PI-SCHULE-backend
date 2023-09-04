package com.logonedigital.PI.SCHULE.Mapper;

import com.logonedigital.PI.SCHULE.Entity.Releve;
import com.logonedigital.PI.SCHULE.dto.releve_dto.ReleveRequest;
import com.logonedigital.PI.SCHULE.dto.releve_dto.ReleveResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Configuration;


@Mapper(componentModel = "spring")
@Configuration
public interface ReleveMapper {
    Releve fromReleveRequest (ReleveRequest releveRequest);

    @Mapping(target = "notes", source = "notes")
    ReleveResponse fromReleve (Releve releve);
}
