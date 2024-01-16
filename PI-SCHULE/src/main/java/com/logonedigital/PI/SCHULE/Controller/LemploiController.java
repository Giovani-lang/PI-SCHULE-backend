package com.logonedigital.PI.SCHULE.Controller;

import com.logonedigital.PI.SCHULE.Entity.Lemploi;
import com.logonedigital.PI.SCHULE.Service.Interface.ILemploiService;
import com.logonedigital.PI.SCHULE.dto.lemploi_dto.LemploiRequest;
import com.logonedigital.PI.SCHULE.dto.lemploi_dto.LemploiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lemploi")
@RequiredArgsConstructor
public class LemploiController {
    private final ILemploiService lemploiService;

    @PostMapping("/add")
    public ResponseEntity<LemploiResponse> addLemploi(@RequestBody LemploiRequest lemploi){
        return new ResponseEntity<>(this.lemploiService.addLemploi(lemploi), HttpStatus.CREATED);
    }

    @GetMapping("detail/{classe}")
    public ResponseEntity<List<LemploiResponse>> findAllLemploiByClasse(@PathVariable(name = "classe") String classe){
          return new ResponseEntity<>(this.lemploiService.findAllLemploiByClasse(classe), HttpStatus.OK);
       }
    @PutMapping("/edit/{id}")
    public ResponseEntity<LemploiResponse> updateLemploi(@PathVariable(name = "id")Long id,@RequestBody LemploiRequest lemploi){
        return new ResponseEntity<>(this.lemploiService.updateLemploi(id, lemploi),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteLemploi(@PathVariable(name = "id")Long id){
        this.lemploiService.deleteLemploi(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
