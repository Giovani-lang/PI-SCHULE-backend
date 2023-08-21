package com.logonedigital.PI.SCHULE.Mapper;

import com.logonedigital.PI.SCHULE.Entity.Enseignant;
import com.logonedigital.PI.SCHULE.dto.enseignant_dto.EnseignantRequestDTO;
import com.logonedigital.PI.SCHULE.dto.enseignant_dto.EnseignantResponseDTO;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

@Mapper(componentModel = "spring")
@Configuration
public interface EnseignantMapper {
    Enseignant fromEnseignantRequestDTO (EnseignantRequestDTO enseignantRequestDTO);

    EnseignantResponseDTO fromEnseignant (Enseignant enseignant);
}
