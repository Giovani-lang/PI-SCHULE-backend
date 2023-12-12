package com.logonedigital.PI.SCHULE.Controller;

import com.logonedigital.PI.SCHULE.Entity.Filiere;
import com.logonedigital.PI.SCHULE.Service.Interface.IFiliereService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/filieres")
public class FiliereController {

    private final IFiliereService filiereService;

    @PostMapping("/add")
    public ResponseEntity<Filiere> addFiliere(@RequestBody Filiere filiere){
        return new ResponseEntity<>(this.filiereService.addFiliere(filiere), HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Filiere>> getAllFiliere(){
        return new ResponseEntity<>(this.filiereService.getFiliere(), HttpStatus.OK);
    }

    @GetMapping("/detail/{nom}")
    public ResponseEntity<Filiere> getByName(@PathVariable (name = "nom")String nom){
        return new ResponseEntity<>(this.filiereService.getByName(nom), HttpStatus.OK);
    }
    @PutMapping("/edit/{nom}")
    public ResponseEntity<Filiere> updateFiliere(@PathVariable(name = "nom")String nom,@RequestBody Filiere filiere){
        return new ResponseEntity<>(this.filiereService.updateFiliere(nom, filiere), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{nom}")
    public ResponseEntity<String> deleteFiliere(@PathVariable(name = "nom")String nom){
        this.filiereService.deleteFiliere(nom);
        return new ResponseEntity<>("delete successfully", HttpStatus.CREATED);
    }
}
