package com.logonedigital.PI.SCHULE.Controller;

import com.logonedigital.PI.SCHULE.Entity.FicheDePresence;
import com.logonedigital.PI.SCHULE.Exception.RessourceExistException;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Service.Interface.IFicheDePresenceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/ficheDePresence")
@RestController
public class FicheDePresenceController {
    private final IFicheDePresenceService ficheDePresenceService;

    public FicheDePresenceController(IFicheDePresenceService ficheDePresenceService) {
        this.ficheDePresenceService = ficheDePresenceService;
    }

    @PostMapping
    public ResponseEntity<FicheDePresence> addFicheDePresence(@RequestBody @Valid FicheDePresence absence) throws RessourceExistException {
        return new ResponseEntity<>(this.ficheDePresenceService.addFicheDePresence(absence), HttpStatus.CREATED);
    }

    @GetMapping("{matricule}")
    public ResponseEntity<FicheDePresence> getFicheDePresence(@PathVariable(name = "matricule") String matricule) throws RessourceNotFoundException {
        return new ResponseEntity<>(this.ficheDePresenceService.getFicheDePresence(matricule),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FicheDePresence>> getFichesDePresence(){
        return new ResponseEntity<>(this.ficheDePresenceService.getFichesDePresence(),HttpStatus.OK);
    }

    @PutMapping("{matricule}")
    public ResponseEntity<FicheDePresence> updateFicheDePresence(@PathVariable(name = "matricule") String matricule,
                                                       @RequestBody FicheDePresence absence) throws RessourceNotFoundException{
        return new ResponseEntity<>(this.ficheDePresenceService.updateFicheDePresence(matricule, absence),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{matricule}")
    public ResponseEntity<String> deleteFicheDePresence(@PathVariable(name = "matricule") String matricule) throws RessourceNotFoundException {
        this.ficheDePresenceService.deleteAbsence(matricule);
        return new ResponseEntity<>("delete successfully",HttpStatus.ACCEPTED);
    }
}
