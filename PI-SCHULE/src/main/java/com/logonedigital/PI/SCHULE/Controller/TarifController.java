package com.logonedigital.PI.SCHULE.Controller;

import com.logonedigital.PI.SCHULE.Service.Interface.ITarifService;
import com.logonedigital.PI.SCHULE.dto.tarif_dto.TarifRequest;
import com.logonedigital.PI.SCHULE.dto.tarif_dto.TarifResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tarifs")
@RequiredArgsConstructor
public class TarifController {
    private final ITarifService tarifService;

    @PostMapping("/add")
    private ResponseEntity<TarifResponse> addTarif(@RequestBody TarifRequest tarifRequest){
        return new ResponseEntity<>(this.tarifService.addTarif(tarifRequest), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    private ResponseEntity<List<TarifResponse>> addTarif(){
        return new ResponseEntity<>(this.tarifService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    private ResponseEntity<TarifResponse> addTarif(@PathVariable(name = "id") Long id,@RequestBody TarifRequest tarifRequest){
        return new ResponseEntity<>(this.tarifService.editTarif(id, tarifRequest), HttpStatus.ACCEPTED);
    }
}
