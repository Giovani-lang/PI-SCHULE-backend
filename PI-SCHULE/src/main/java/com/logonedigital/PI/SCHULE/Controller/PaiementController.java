package com.logonedigital.PI.SCHULE.Controller;

import com.logonedigital.PI.SCHULE.Service.Interface.IPaiementService;
import com.logonedigital.PI.SCHULE.dto.paiement_dto.PaiementRequest;
import com.logonedigital.PI.SCHULE.dto.paiement_dto.PaiementResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/paiements")
public class PaiementController {
    private final IPaiementService paiementService;


    @PostMapping("/add")
    public ResponseEntity<PaiementResponse> addPaiement(@RequestBody @Valid PaiementRequest paiementRequest){
        return new ResponseEntity<>(this.paiementService.addPaiement(paiementRequest), HttpStatus.CREATED);
    }
}
