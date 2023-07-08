package com.logonedigital.PI.SCHULE.Service.Interface;

import com.logonedigital.PI.SCHULE.Entity.Note;

import java.util.List;

public interface INoteService {

    Note addNote(Note note);
    Note getNote(String codeMatiere);
    List<Note> getNotes();
    Note updateNote(String codeMatiere,Note note);
    void deleteNote(String codeMatiere);
}
