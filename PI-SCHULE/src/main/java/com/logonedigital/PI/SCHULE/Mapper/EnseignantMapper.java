package com.logonedigital.PI.SCHULE.Mapper;

import com.logonedigital.PI.SCHULE.Entity.Enseignant;
import com.logonedigital.PI.SCHULE.Entity.FicheDePresence;
import com.logonedigital.PI.SCHULE.Entity.Note;
import com.logonedigital.PI.SCHULE.dto.enseignant_dto.EnseignantRequestDTO;
import com.logonedigital.PI.SCHULE.dto.enseignant_dto.EnseignantResponseDTO;
import com.logonedigital.PI.SCHULE.dto.ficheDePresence_dto.FicheDePresenceRequest;
import com.logonedigital.PI.SCHULE.dto.note_dto.NoteRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Mapper(componentModel = "spring")
@Configuration
public interface EnseignantMapper {
    Enseignant fromEnseignantRequestDTO (EnseignantRequestDTO enseignantRequestDTO);

    EnseignantResponseDTO fromEnseignant (Enseignant enseignant);
}
