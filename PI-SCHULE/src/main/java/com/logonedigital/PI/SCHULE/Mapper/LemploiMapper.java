package com.logonedigital.PI.SCHULE.Mapper;

import com.logonedigital.PI.SCHULE.Entity.Lemploi;
import com.logonedigital.PI.SCHULE.dto.lemploi_dto.LemploiRequest;
import com.logonedigital.PI.SCHULE.dto.lemploi_dto.LemploiResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.annotation.Configuration;

@Configuration
@Mapper(componentModel = "spring")
public interface LemploiMapper {
    Lemploi fromLemploiRequest (LemploiRequest lemploiRequest);

    @Mappings({
        @Mapping(source = "enseignant", target = "enseignant"),
        @Mapping(source = "matiere", target = "matiere"),
        @Mapping(source = "classe", target = "classe")
    })
    LemploiResponse fromLemploi (Lemploi lemploi);
}
