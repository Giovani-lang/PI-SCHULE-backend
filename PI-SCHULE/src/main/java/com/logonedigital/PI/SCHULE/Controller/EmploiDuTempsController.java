package com.logonedigital.PI.SCHULE.Controller;

import com.logonedigital.PI.SCHULE.Entity.EmploiDuTemps;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Service.Interface.EmploiDuTempsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/emploisDuTemps")
public class EmploiDuTempsController {
    private final EmploiDuTempsService emploiDuTempsService;
    public EmploiDuTempsController(EmploiDuTempsService emploiDuTempsService){
        this.emploiDuTempsService= emploiDuTempsService;
    }
    @PostMapping
    public ResponseEntity<EmploiDuTemps> addEmploiDuTemps(@RequestBody EmploiDuTemps emploiDuTemps){
        return new ResponseEntity<>(this.emploiDuTempsService.addEmploiDuTemps(emploiDuTemps), HttpStatus.CREATED) ;
    }
    @GetMapping
    public List<EmploiDuTemps> getEmploisDuTemps(){
        return this.emploiDuTempsService.getEmploisDuTemps();
    }
    @GetMapping("{id}")
    public ResponseEntity<EmploiDuTemps> getEmploiDuTemps(@PathVariable(name = "id") Integer id)
        throws RessourceNotFoundException {
            return new ResponseEntity<>(this.emploiDuTempsService.getEmploiDuTemps(id),HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmploiDeTemps(@PathVariable(name = "id")Integer id) throws RessourceNotFoundException{
        this.emploiDuTempsService.deleteEmploiDuTemps(id);
        return new ResponseEntity<>("Emploi du temps deleted successfully", HttpStatus.ACCEPTED);
    }
    @PutMapping("{id}")
    public ResponseEntity<EmploiDuTemps> updateEmploiDuTemps(@PathVariable(name = "id") Integer id, @RequestBody EmploiDuTemps emploiDuTemps) throws RessourceNotFoundException{
        return new ResponseEntity<>(this.emploiDuTempsService.updateEmploiDuTemps(emploiDuTemps, id), HttpStatus.ACCEPTED);
    }
}
