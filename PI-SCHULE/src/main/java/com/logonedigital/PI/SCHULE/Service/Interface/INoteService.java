package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.Note;
import com.logonedigital.PI.SCHULE.dto.note_dto.NoteRequest;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public interface INoteService {

    Note addNote(NoteRequest noteRequest);
    Note getNote(String codeMatiere);
    List<Note> getNotes();
    Note updateNote(String codeMatiere,NoteRequest noteRequest);
    void deleteNote(String codeMatiere);
}
