package com.logonedigital.PI.SCHULE.Controller;


import com.logonedigital.PI.SCHULE.Entity.Matiere;
import com.logonedigital.PI.SCHULE.Service.Interface.IMatiereService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/matieres")
public class MatiereController {

    private final IMatiereService matiereService;

    @PostMapping("/add")
    public ResponseEntity<Matiere> addMatiere(@RequestBody Matiere matiere){
        return new ResponseEntity<>(this.matiereService.addMatiere(matiere), HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Matiere>> getAllMatiere(){
        return new ResponseEntity<>(this.matiereService.getMatiere(), HttpStatus.OK);
    }
    @PutMapping("/edit/{intitule}")
    public ResponseEntity<Matiere> updateMatiere(@PathVariable(name = "intitule")String intitule,@RequestBody Matiere matiere){
        return new ResponseEntity<>(this.matiereService.updateMatiere(intitule, matiere), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{intitule}")
    public ResponseEntity<String> deleteMatiere(@PathVariable(name = "intitule")String intitule){
        this.matiereService.deleteMatiere(intitule);
        return new ResponseEntity<>("delete successfully", HttpStatus.CREATED);
    }
}
