package com.logonedigital.PI.SCHULE.Mapper;

import com.logonedigital.PI.SCHULE.Entity.FicheDePresence;
import com.logonedigital.PI.SCHULE.dto.ficheDePresence_dto.FicheDePresenceRequest;
import com.logonedigital.PI.SCHULE.dto.ficheDePresence_dto.FicheDePresenceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Configuration;

@Mapper(componentModel = "spring")
@Configuration
public interface FicheDePresenceMapper {

    FicheDePresence fromFicheDePresenceResquest (FicheDePresenceRequest ficheDePresenceRequest);
    @Mapping(target = "enseignant", source = "enseignant")
    FicheDePresenceResponse fromFicheDePresence (FicheDePresence ficheDePresence);
}
