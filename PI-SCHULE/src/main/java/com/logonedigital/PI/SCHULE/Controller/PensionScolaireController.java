package com.logonedigital.PI.SCHULE.Controller;


import com.logonedigital.PI.SCHULE.Entity.AnneeAcademique;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Model.AnneeAcademiqueModel;
import com.logonedigital.PI.SCHULE.Service.Interface.PensionScolaireService;
import com.logonedigital.PI.SCHULE.dto.pensionScolaire_dto.PensionRequest;
import com.logonedigital.PI.SCHULE.dto.pensionScolaire_dto.PensionResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pensionsScolaire")
public class PensionScolaireController {
    private final PensionScolaireService pensionScolaireService;
    public PensionScolaireController(PensionScolaireService pensionScolaireService){
        this.pensionScolaireService=pensionScolaireService;
    }
    @PostMapping("/add")
    public ResponseEntity<PensionResponse> addPensionScolaire(@RequestBody @Valid PensionRequest pensionScolaire) {
    return new ResponseEntity<>(this.pensionScolaireService.addPensionScolaire(pensionScolaire), HttpStatus.CREATED);
}
    @GetMapping("/getAll/{annee}")
    public ResponseEntity<List<PensionResponse>> getPensionsScolaire(@PathVariable(name = "annee") Long annee){
    return new ResponseEntity<>(this.pensionScolaireService.getPensionsScolaire(annee),HttpStatus.OK);
    }
    @GetMapping("/detail/{matricule}/{annee}")
    public ResponseEntity<PensionResponse> getPensionScolaire(@PathVariable(name = "matricule")String matricule,@PathVariable(name = "annee") Long annee) {
        return new ResponseEntity<>(this.pensionScolaireService.getPensionScolaire(matricule,annee), HttpStatus.OK);
    }

//    @GetMapping("/detail/{id}/{matricule}")
//    public ResponseEntity<PensionResponse> getPensionScolaireWithTotalPayment(@PathVariable(name = "id") Long id,
//                                                                              @PathVariable(name = "matricule") String matricule) {
//        return new ResponseEntity<>(this.pensionScolaireService.getPensionScolaireWithTotalPayment(id,matricule), HttpStatus.OK);
//    }

//    @DeleteMapping("/delete/{matricule}")
//    public ResponseEntity<String> deletePensionScolaire(@PathVariable(name = "matricule") String matricule){
//        this.pensionScolaireService.deletePensionScolaire(matricule);
//        return new ResponseEntity<>("Deleted successfully", HttpStatus.ACCEPTED);
//    }
    @PutMapping("/edit/{matricule}/{annee}")
    public ResponseEntity <PensionResponse> updatePensionScolaire(@PathVariable(name = "matricule") String matricule,
                                           @RequestBody PensionRequest pensionScolaire,@PathVariable(name = "annee") Long annee)throws RessourceNotFoundException
    {
        return new ResponseEntity<>(this.pensionScolaireService.updatePensionScolaire(pensionScolaire, matricule,annee), HttpStatus.OK);
    }
}

