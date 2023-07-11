package com.logonedigital.PI.SCHULE.Controller;

import com.logonedigital.PI.SCHULE.Entity.Enseignant;
import com.logonedigital.PI.SCHULE.Exception.RessourceFoundException;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Service.Interface.IEnseignantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/enseignants")
public class EnseignantController {
    private final IEnseignantService enseignantService;

    public EnseignantController(IEnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    @PostMapping
    public ResponseEntity<Enseignant> addEnseignant(@RequestBody @Valid Enseignant enseignant) throws RessourceFoundException {
        return new ResponseEntity<>(this.enseignantService.addEnseignant(enseignant), HttpStatus.CREATED);
    }

    @GetMapping("{email}")
    public ResponseEntity<Enseignant> getEnseignant(@PathVariable(name = "email") String email) throws RessourceNotFoundException{
        return new ResponseEntity<>(this.enseignantService.getEnseignant(email),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Enseignant>> getEnseigants(){
        return new ResponseEntity<>(this.enseignantService.getEnseigants(),HttpStatus.OK);
    }

    @PutMapping("{email}")
    public ResponseEntity<Enseignant> updateEnseignant(@PathVariable(name = "email") String email,
                                                       @RequestBody Enseignant enseignant) throws RessourceNotFoundException{
        return new ResponseEntity<>(this.enseignantService.updateEnseignant(email, enseignant),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{email}")
    public ResponseEntity<String> deleteEnseignant(@PathVariable(name = "email") String email) throws RessourceNotFoundException {
        this.enseignantService.deleteEnseignant(email);
        return new ResponseEntity<>("delete successfully",HttpStatus.ACCEPTED);
    }
}
