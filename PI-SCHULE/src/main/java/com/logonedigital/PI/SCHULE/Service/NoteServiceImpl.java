package com.logonedigital.PI.SCHULE.Service;

import com.logonedigital.PI.SCHULE.Entity.Note;
import com.logonedigital.PI.SCHULE.Exception.RessourceExistException;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Mapper.NoteMapper;
import com.logonedigital.PI.SCHULE.Repository.NoteRepository;
import com.logonedigital.PI.SCHULE.Service.Interface.INoteService;
import com.logonedigital.PI.SCHULE.dto.note_dto.NoteRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class NoteServiceImpl implements INoteService {

    private final NoteRepository noteRepo;
    private final NoteMapper noteMapper;
    public NoteServiceImpl(NoteRepository noteRepo, NoteMapper noteMapper) {
        this.noteRepo = noteRepo;
        this.noteMapper = noteMapper;
    }

    @Override
    public Note addNote(NoteRequest noteRequest) throws RessourceExistException {
        Note note = this.noteMapper.fromNoteRequest(noteRequest);
        Optional<Note> nt = this.noteRepo.findByNomMatiere(note.getNomMatiere());
        Optional<Note> note1= this.noteRepo.findByCodeMatiere(note.getCodeMatiere());
        if (nt.isPresent()){
            throw new RessourceExistException("A matiere with this name already exists");
        }else if (note1.isPresent()){
            throw new RessourceExistException("code matiere already exist" );
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
    public Note updateNote(String codeMatiere, NoteRequest noteRequest) throws RessourceNotFoundException {
       try {
           Note oldNote = this.noteRepo.findByCodeMatiere(codeMatiere).get();

           oldNote.setNomMatiere(noteRequest.getNomMatiere());
           oldNote.setNoteControle(noteRequest.getNoteControle());
           oldNote.setNoteSession(noteRequest.getNoteSession());
           oldNote.setCoefficient(noteRequest.getCoefficient());

           Note noteUpdated= this.noteRepo.save(oldNote);
           return noteUpdated;
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
