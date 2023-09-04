package com.logonedigital.PI.SCHULE.Mapper;

import com.logonedigital.PI.SCHULE.Entity.Note;
import com.logonedigital.PI.SCHULE.dto.note_dto.NoteRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Configuration;

@Mapper(componentModel = "spring")
@Configuration
public interface NoteMapper {
    NoteMapper INSTANCE = Mappers.getMapper(NoteMapper.class);

    Note fromNoteRequest (NoteRequest noteRequest);
}
