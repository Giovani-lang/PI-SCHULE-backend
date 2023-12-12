package com.logonedigital.PI.SCHULE.Controller;

import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Service.Interface.IEmploiDuTempsService;
import com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto.EmploiDuTempsRequest;
import com.logonedigital.PI.SCHULE.dto.emploiDuTemps_dto.EmploiDuTempsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/emploisDuTemps")
public class EmploiDuTempsController {
    private final IEmploiDuTempsService emploiDuTempsService;
    public EmploiDuTempsController(IEmploiDuTempsService emploiDuTempsService){
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
    @GetMapping("/detail/{classe}")
    public ResponseEntity<EmploiDuTempsResponse> getEmploiDuTemps(@PathVariable(name = "classe") String classe)
        throws RessourceNotFoundException {
            return new ResponseEntity<>(this.emploiDuTempsService.getEmploiDuTemps(classe),HttpStatus.OK);

    }
    @DeleteMapping("/delete/{classe}")
    public ResponseEntity<String> deleteEmploiDeTemps(@PathVariable(name = "classe")String classe) throws RessourceNotFoundException{
        this.emploiDuTempsService.deleteEmploiDuTemps(classe);
        return new ResponseEntity<>("Emploi du temps deleted successfully", HttpStatus.ACCEPTED);
    }
    @PutMapping("/edit/{classe}")
    public ResponseEntity<EmploiDuTempsResponse> updateEmploiDuTemps(@PathVariable(name = "classe") String classe, @RequestBody EmploiDuTempsRequest emploiDuTemps) throws RessourceNotFoundException{
        return new ResponseEntity<>(this.emploiDuTempsService.updateEmploiDuTemps(emploiDuTemps, classe), HttpStatus.ACCEPTED);
    }
}
