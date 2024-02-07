package com.logonedigital.PI.SCHULE.Mapper;

import com.logonedigital.PI.SCHULE.Entity.Classe;
import com.logonedigital.PI.SCHULE.dto.classe_dto.ClasseRequest;
import com.logonedigital.PI.SCHULE.dto.classe_dto.ClasseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Configuration;

@Configuration
@Mapper(componentModel = "spring")
public interface ClasseMapper {

    Classe fromClasseRequest (ClasseRequest classeRequest);

    @Mapping(source = "filiere", target = "filiere")
    @Mapping(source = "option", target = "option")
    @Mapping(source = "tarif", target = "tarif")
    ClasseResponse fromClasse (Classe classe);
}
