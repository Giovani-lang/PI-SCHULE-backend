package com.logonedigital.PI.SCHULE.Controller;


import com.logonedigital.PI.SCHULE.Entity.Administration;
import com.logonedigital.PI.SCHULE.Entity.PensionScolaire;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Service.Interface.PensionScolaireService;
import com.logonedigital.PI.SCHULE.dto.pensionScolaire_dto.PensionRequest;
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
public PensionScolaire addPensionScolaire(@RequestBody PensionRequest pensionScolaire) {
    return this.pensionScolaireService.addPensionScolaire(pensionScolaire);
}
@GetMapping("/getAll")
    public List<PensionScolaire> getPensionsScolaire(){
    return this.pensionScolaireService.getPensionsScolaire();
    }
    @GetMapping("/detail/{nomElève}")
    public PensionScolaire getPensionScolaire(@PathVariable(name = "nomElève")String nomElève) {
        return this.pensionScolaireService.getPensionScolaire(nomElève);
    }

    @DeleteMapping("/delete/{nomElève}")
    public String deletePensionScolaire(@PathVariable(name = "nomElève") String nomElève){
        this.pensionScolaireService.deletePensionScolaire(nomElève);
        return "Deleted successfully";
    }
    @PutMapping("/edit/{nomElève}")
    public ResponseEntity <PensionScolaire> updatePensionScolaire(@PathVariable(name = "nomElève") String nomElève,
                                           @RequestBody PensionRequest pensionScolaire)throws RessourceNotFoundException
    {
        return new ResponseEntity<>(this.pensionScolaireService.updatePensionScolaire(pensionScolaire, nomElève), HttpStatus.OK);
    }
}

