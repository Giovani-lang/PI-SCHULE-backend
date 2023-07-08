package com.logonedigital.PI.SCHULE.Controller;

import com.logonedigital.PI.SCHULE.Entity.Note;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Service.Interface.INoteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteContoller {

    private final INoteService noteService;

    public NoteContoller(INoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody @Valid Note note) {
        return new ResponseEntity<>(this.noteService.addNote(note), HttpStatus.CREATED);
    }

    @GetMapping("{codeMatiere}")
    public ResponseEntity<Note> getNote(@PathVariable(name = "codeMatiere") String codeMatiere) throws RessourceNotFoundException {
        return new ResponseEntity<>(this.noteService.getNote(codeMatiere),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Note>> getNotes(){
        return new ResponseEntity<>(this.noteService.getNotes(),HttpStatus.OK);
    }

    @PutMapping("{codeMatiere}")
    public ResponseEntity<Note> updateNote(@PathVariable(name = "codeMatiere") String codeMatiere,
                                                       @RequestBody Note note) throws RessourceNotFoundException{
        return new ResponseEntity<>(this.noteService.updateNote(codeMatiere, note),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{codeMatiere}")
    public ResponseEntity<String> deleteNote(@PathVariable(name = "codeMatiere") String codeMatiere) throws RessourceNotFoundException {
        this.noteService.deleteNote(codeMatiere);
        return new ResponseEntity<>("delete successfully",HttpStatus.ACCEPTED);
    }
}
