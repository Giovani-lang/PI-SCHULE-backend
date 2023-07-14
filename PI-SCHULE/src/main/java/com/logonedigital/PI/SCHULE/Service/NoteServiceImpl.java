package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Note;
import com.logonedigital.PI.SCHULE.Entity.Releve;
import com.logonedigital.PI.SCHULE.Exception.ResourceExistException;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Repository.NoteRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.INoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class NoteServiceImpl implements INoteService {

    private final NoteRepository noteRepo;

    public NoteServiceImpl(NoteRepository noteRepo) {
        this.noteRepo = noteRepo;
    }

    @Override
    public Note addNote(Note note) throws ResourceExistException {
        Note trustNote = Note.build(
                note.getCodeMatiere(),
                note.getNomMatiere(),
                note.getCoefficient(),
                note.getNoteControle(),
                note.getNoteSession(),
                note.getMoyenne(note.getNoteControle(), note.getNoteSession(), note.getCoefficient()),
                new Releve()
        );
        Optional<Note> nt = this.noteRepo.findByNomMatiere(note.getNomMatiere());
        if (nt.isPresent()){
            throw new ResourceExistException("A matiere with this name already exists");
        }
        return this.noteRepo.save(note);
    }

    @Override
    public Note getNote(String codeMatiere) throws RessourceNotFoundException {
       try {
           return this.noteRepo.findById(codeMatiere).get();
       }catch (Exception ex){
           throw new RessourceNotFoundException("this  codeMatiere :"+codeMatiere+
                     " doesn't exist in our data base");
       }
    }

    @Override
    public List<Note> getNotes() {
        return this.noteRepo.findAll();
    }

    @Override
    public Note updateNote(String codeMatiere, Note note) throws RessourceNotFoundException {
       try {
           Note newNote = this.noteRepo.findById(codeMatiere).get();
           newNote.setNomMatiere(note.getNomMatiere());
           newNote.setNoteControle(note.getNoteControle());
           newNote.setNoteSession(note.getNoteSession());
           newNote.setCoefficient(note.getCoefficient());

           return this.noteRepo.save(newNote);
       }catch (Exception ex){
           throw new RessourceNotFoundException("this  codeMatiere :"+codeMatiere+
                   " doesn't exist in our data base");
       }
    }

    @Override
    public void deleteNote(String codeMatiere) throws RessourceNotFoundException{
        try {
            this.noteRepo.deleteById(codeMatiere);
        }catch (Exception ex){
            throw new RessourceNotFoundException("this  codeMatiere :"+codeMatiere+
                    " doesn't exist in our data base");
        }
    }
}
