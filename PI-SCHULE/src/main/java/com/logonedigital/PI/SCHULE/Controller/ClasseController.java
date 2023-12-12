package com.logonedigital.PI.SCHULE.Controller;

import com.logonedigital.PI.SCHULE.Entity.Classe;
import com.logonedigital.PI.SCHULE.Service.Interface.IClasseService;
import com.logonedigital.PI.SCHULE.dto.classe_dto.ClasseRequest;
import com.logonedigital.PI.SCHULE.dto.classe_dto.ClasseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/classes")
public class ClasseController {
    private final IClasseService classeService;

    @PostMapping("/add")
    public ResponseEntity<ClasseResponse> addClasse(@RequestBody ClasseRequest classe){
        return new ResponseEntity<>(this.classeService.addClasse(classe), HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<ClasseResponse>> getAllClasse(){
        return new ResponseEntity<>(this.classeService.getClasse(), HttpStatus.OK);
    }
    @PutMapping("/edit/{nom}")
    public ResponseEntity<ClasseResponse> updateClasse(@PathVariable(name = "nom")String nom,@RequestBody ClasseRequest classe){
        return new ResponseEntity<>(this.classeService.updateClasse(nom, classe), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{nom}")
    public ResponseEntity<String> deleteClasse(@PathVariable(name = "nom")String nom){
        this.classeService.deleteClasse(nom);
        return new ResponseEntity<>("delete successfully", HttpStatus.CREATED);
    }
}
