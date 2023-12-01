package com.logonedigital.PI.SCHULE.Controller;

import com.logonedigital.PI.SCHULE.Entity.AnneeAcademique;
import com.logonedigital.PI.SCHULE.Service.Interface.IAnneeAcademiqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/anneeAcademique")
public class AnneeAcademiqueController {

    private final IAnneeAcademiqueService anneeAcademiqueService;

    @PostMapping("/add")
    public ResponseEntity<AnneeAcademique> addAnnee(@RequestBody AnneeAcademique anneeAcademique){
        return new ResponseEntity<>(this.anneeAcademiqueService.addAnnee(anneeAcademique), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{annees}")
    public ResponseEntity<AnneeAcademique> editAnnee(@PathVariable(name = "annees") String annees,
                                                     @RequestBody AnneeAcademique anneeAcademique){
        return new ResponseEntity<>(this.anneeAcademiqueService.editAnnee(annees,anneeAcademique),HttpStatus.ACCEPTED);
    }
}
