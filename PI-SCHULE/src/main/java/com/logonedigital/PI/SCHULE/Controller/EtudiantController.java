package com.logonedigital.PI.SCHULE.Controller;

import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Service.Interface.IEtudiantService;
import com.logonedigital.PI.SCHULE.dto.etudiant_dto.EtudiantRequestDTO;
import com.logonedigital.PI.SCHULE.dto.etudiant_dto.EtudiantResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/etudiants")
@RequiredArgsConstructor
public class EtudiantController {

    private final IEtudiantService etudiantService;

    @PostMapping("/add")
    public ResponseEntity<EtudiantResponseDTO> addEtudiant(@Valid @RequestBody EtudiantRequestDTO etudiantRequestDTO)  {
        return new ResponseEntity<>(this.etudiantService.addEtudiant(etudiantRequestDTO),HttpStatus.CREATED );
    }

    @GetMapping("/detailWithMatricule/{matricule}")
    public ResponseEntity<EtudiantResponseDTO> getEtudiantByMatricule(@PathVariable(name = "matricule") String matricule)
            throws RessourceNotFoundException{
        return new ResponseEntity<>(this.etudiantService.getEtudiantByMatricule(matricule),HttpStatus.ACCEPTED );
    }

    @GetMapping("/detailWithEmail/{email}")
    public ResponseEntity<EtudiantResponseDTO> getEtudiantByEmail(@PathVariable(name = "email") String email)
            throws RessourceNotFoundException{
        return new ResponseEntity<>(this.etudiantService.getEtudiantByEmail(email),HttpStatus.ACCEPTED );
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EtudiantResponseDTO>> getEtudiants() {
        return new ResponseEntity<>(this.etudiantService.getEtudiants(), HttpStatus.OK);
    }

    @GetMapping("/getAllByClasse/{classe}")
    public ResponseEntity<List<EtudiantResponseDTO>> getEtudiants(@PathVariable(name = "classe") String classe) {
        return new ResponseEntity<>(this.etudiantService.getEtudiantsByClasse(classe), HttpStatus.OK);
    }

    @PutMapping("/edit/{matricule}")
    public ResponseEntity<EtudiantResponseDTO> updateEtudiant(@PathVariable(name = "matricule") String matricule,
                                                              @RequestBody EtudiantRequestDTO etudiantRequestDTO)
                                                              throws RessourceNotFoundException {
        return new ResponseEntity<>(this.etudiantService.updateEtudiant(matricule, etudiantRequestDTO),HttpStatus.ACCEPTED );
    }

    @DeleteMapping("/delete/{matricule}")
    public ResponseEntity<String> deleteEtudiant(@PathVariable(name = "matricule") String matricule) throws RessourceNotFoundException {
        this.etudiantService.deleteEtudiant(matricule);
        return new ResponseEntity<>("delete successfully", HttpStatus.OK);
    }
}
