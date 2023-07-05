package com.logonedigital.PI.SCHULE.Controller;

import com.logonedigital.PI.SCHULE.Entity.Enseignant;
import com.logonedigital.PI.SCHULE.Service.Interface.IEnseignantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/enseignants")
public class EnseignantController {
    private final IEnseignantService enseignantService;

    public EnseignantController(IEnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    @PostMapping
    public ResponseEntity<Enseignant> addEnseignant(Enseignant enseignant){
        return new ResponseEntity<>(this.enseignantService.addEnseignant(enseignant), HttpStatus.CREATED);
    }
}
