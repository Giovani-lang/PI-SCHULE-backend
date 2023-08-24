package com.logonedigital.PI.SCHULE.Mapper;

import com.logonedigital.PI.SCHULE.Entity.Etudiant;
import com.logonedigital.PI.SCHULE.dto.etudiant_dto.EtudiantRequestDTO;
import com.logonedigital.PI.SCHULE.dto.etudiant_dto.EtudiantResponseDTO;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

@Mapper(componentModel = "spring")
@Configuration
public interface EtudiantMapper {
    Etudiant fromEtudiantRequestDTO (EtudiantRequestDTO etudiantRequestDTO);
    EtudiantResponseDTO fromEtudiant (Etudiant etudiant);
}
