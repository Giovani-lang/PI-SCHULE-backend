package com.logonedigital.PI.SCHULE.Controller;

import com.logonedigital.PI.SCHULE.Entity.FicheDePresence;
import com.logonedigital.PI.SCHULE.Exception.ResourceExistException;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Service.Interface.IFicheDePresenceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/api/v1/ficheDePresence")
@RestController
public class FicheDePresenceController {
    private final IFicheDePresenceService ficheDePresenceService;

    public FicheDePresenceController(IFicheDePresenceService ficheDePresenceService) {
        this.ficheDePresenceService = ficheDePresenceService;
    }

    @PostMapping
    public ResponseEntity<FicheDePresence> addAbsence(@RequestBody @Valid FicheDePresence absence) throws ResourceExistException {
        return new ResponseEntity<>(this.ficheDePresenceService.addAbsence(absence), HttpStatus.CREATED);
    }

    @GetMapping("{matricule}")
    public ResponseEntity<FicheDePresence> getEnseignant(@PathVariable(name = "matricule") String matricule) throws RessourceNotFoundException {
        return new ResponseEntity<>(this.ficheDePresenceService.getAbsence(matricule),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FicheDePresence>> getEnseigants(){
        return new ResponseEntity<>(this.ficheDePresenceService.getAbsences(),HttpStatus.OK);
    }

    @PutMapping("{matricule}")
    public ResponseEntity<FicheDePresence> updateEnseignant(@PathVariable(name = "matricule") String matricule,
                                                       @RequestBody FicheDePresence absence) throws RessourceNotFoundException{
        return new ResponseEntity<>(this.ficheDePresenceService.updateAbscence(matricule, absence),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{matricule}")
    public ResponseEntity<String> deleteEnseignant(@PathVariable(name = "matricule") String matricule) throws RessourceNotFoundException {
        this.ficheDePresenceService.deleteAbsence(matricule);
        return new ResponseEntity<>("delete successfully",HttpStatus.ACCEPTED);
    }
}
