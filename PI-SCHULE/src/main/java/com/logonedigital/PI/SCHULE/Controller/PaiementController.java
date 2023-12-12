package com.logonedigital.PI.SCHULE.Controller;

import com.logonedigital.PI.SCHULE.Service.Interface.IPaiementService;
import com.logonedigital.PI.SCHULE.dto.paiement_dto.PaiementRequest;
import com.logonedigital.PI.SCHULE.dto.paiement_dto.PaiementResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/paiements")
public class PaiementController {
    private final IPaiementService paiementService;


    @PostMapping("/add")
    public ResponseEntity<PaiementResponse> addPaiement(@RequestBody @Valid PaiementRequest paiementRequest){
        return new ResponseEntity<>(this.paiementService.addPaiement(paiementRequest), HttpStatus.CREATED);
    }

    @GetMapping("/detail/{matricule}")
    public ResponseEntity<List<PaiementResponse>> findPaiementByMatricule(@PathVariable(name = "matricule")String matricule){
        return new ResponseEntity<>(this.paiementService.getPaiement(matricule), HttpStatus.OK);
    }

//    @GetMapping("/getAll")
//    public ResponseEntity<List<PaiementResponse>> findPaiementByMatricule(){
//        return new ResponseEntity<>(this.paiementService.getAllPaiement(), HttpStatus.OK);
//    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<PaiementResponse> updatePaiement(@PathVariable(name = "id")Long id,@RequestBody PaiementRequest paiementRequest){
        return new ResponseEntity<>(this.paiementService.editPaiement(id, paiementRequest), HttpStatus.CREATED);
    }
}
