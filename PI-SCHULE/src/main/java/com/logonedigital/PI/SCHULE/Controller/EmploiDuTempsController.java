package com.logonedigital.PI.SCHULE.Controller;

import com.logonedigital.PI.SCHULE.Entity.EmploiDuTemps;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Service.Interface.EmploiDuTempsService;
import com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto.EmploiDuTempsRequest;
import com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto.EmploiDuTempsResponse;
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
    @PostMapping("/add")
    public ResponseEntity<EmploiDuTempsResponse> addEmploiDuTemps(@RequestBody EmploiDuTempsRequest emploiDuTemps){
        return new ResponseEntity<>(this.emploiDuTempsService.addEmploiDuTemps(emploiDuTemps), HttpStatus.CREATED) ;
    }
    @GetMapping("/getAll")
    public List<EmploiDuTempsResponse> getEmploisDuTemps(){
        return this.emploiDuTempsService.getEmploisDuTemps();
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<EmploiDuTempsResponse> getEmploiDuTemps(@PathVariable(name = "id") Integer id)
        throws RessourceNotFoundException {
            return new ResponseEntity<>(this.emploiDuTempsService.getEmploiDuTemps(id),HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmploiDeTemps(@PathVariable(name = "id")Integer id) throws RessourceNotFoundException{
        this.emploiDuTempsService.deleteEmploiDuTemps(id);
        return new ResponseEntity<>("Emploi du temps deleted successfully", HttpStatus.ACCEPTED);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<EmploiDuTempsResponse> updateEmploiDuTemps(@PathVariable(name = "id") Integer id, @RequestBody EmploiDuTempsRequest emploiDuTemps) throws RessourceNotFoundException{
        return new ResponseEntity<>(this.emploiDuTempsService.updateEmploiDuTemps(emploiDuTemps, id), HttpStatus.ACCEPTED);
    }
}
