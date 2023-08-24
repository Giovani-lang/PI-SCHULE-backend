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

    @PostMapping
    public ResponseEntity<EtudiantResponseDTO> addEtudiant(@Valid @RequestBody EtudiantRequestDTO etudiantRequestDTO)  {
        return new ResponseEntity<>(this.etudiantService.addEtudiant(etudiantRequestDTO),HttpStatus.CREATED );
    }

    @GetMapping("{email}")
    public ResponseEntity<EtudiantResponseDTO> getEtudiant(@PathVariable(name = "email") String email)
            throws RessourceNotFoundException{
        return new ResponseEntity<>(this.etudiantService.getEtudiant(email),HttpStatus.ACCEPTED );
    }

    @GetMapping
    public ResponseEntity<List<EtudiantResponseDTO>> getEtudiants() {
        return new ResponseEntity<>(this.etudiantService.getEtudiants(), HttpStatus.OK);
    }

    @PutMapping("{email}")
    public ResponseEntity<EtudiantResponseDTO> updateEtudiant(@PathVariable(name = "email") String email,
                                                              @RequestBody EtudiantRequestDTO etudiantRequestDTO)
                                                              throws RessourceNotFoundException {
        return new ResponseEntity<>(this.etudiantService.updateEtudiant(email, etudiantRequestDTO),HttpStatus.ACCEPTED );
    }

    @DeleteMapping("{email}")
    public ResponseEntity<String> deleteEtudiant(@PathVariable(name = "email") String email) throws RessourceNotFoundException {
        this.etudiantService.deleteEtudiant(email);
        return new ResponseEntity<>("delete successfully", HttpStatus.OK);
    }
}
