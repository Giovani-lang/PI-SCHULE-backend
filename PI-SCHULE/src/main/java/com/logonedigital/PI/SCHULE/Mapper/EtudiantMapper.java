package com.logonedigital.PI.SCHULE.Mapper;

import com.logonedigital.PI.SCHULE.Entity.*;
import com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto.EmploiDuTempsRequest;
import com.logonedigital.PI.SCHULE.dto.etudiant_dto.EtudiantRequestDTO;
import com.logonedigital.PI.SCHULE.dto.etudiant_dto.EtudiantResponseDTO;
import com.logonedigital.PI.SCHULE.dto.ficheDePresence_dto.FicheDePresenceRequest;
import com.logonedigital.PI.SCHULE.dto.note_dto.NoteRequest;
import com.logonedigital.PI.SCHULE.dto.pensionScolaire_dto.PensionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Mapper(componentModel = "spring")
@Configuration
public interface EtudiantMapper {
    Etudiant fromEtudiantRequestDTO (EtudiantRequestDTO etudiantRequestDTO);
    List<Note> fromNoteRequest (List<NoteRequest> note);
    List<FicheDePresence> fromFicheDePresenceRequest (List<FicheDePresenceRequest> fiches);
    EmploiDuTemps fromEmploiDuTempsRequest (EmploiDuTempsRequest emploiDuTempsRequest);
    List<PensionScolaire> fromPensionRequest (List<PensionRequest> pensionRequests);



    @Mapping(target = "notes", source = "notes")
    @Mapping(target = "emploisDuTemps", source = "emploiDuTemps")
    @Mapping(target = "fichesDePresence",source = "ficheDePresence")
    @Mapping(target = "pensions", source = "pensionScolaires")
    EtudiantResponseDTO fromEtudiant (Etudiant etudiant);
}
