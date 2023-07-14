package com.logonedigital.PI.SCHULE.Controller;

import com.logonedigital.PI.SCHULE.Entity.Releve;
import com.logonedigital.PI.SCHULE.Exception.RessourceExistException;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Service.Interface.IReleveService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/releves")
public class ReleveController {

    private final IReleveService releveService;

    public ReleveController(IReleveService releveService) {
        this.releveService = releveService;
    }

    @PostMapping
    public ResponseEntity<Releve> addReleve(@RequestBody @Valid Releve releve)throws RessourceExistException {
        return new ResponseEntity<>(this.releveService.addModule(releve), HttpStatus.CREATED);
    }

    @GetMapping("{module}")
    public ResponseEntity<Releve> getReleve(@PathVariable(name = "module") String module) throws RessourceNotFoundException {
        return new ResponseEntity<>(this.releveService.getModule(module),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Releve>> getReleves(){
        return new ResponseEntity<>(this.releveService.getModule(),HttpStatus.OK);
    }

    @PutMapping("{module}")
    public ResponseEntity<Releve> updateReleve(@PathVariable(name = "module") String module,
                                           @RequestBody Releve releve) throws RessourceNotFoundException{
        return new ResponseEntity<>(this.releveService.updateModule(module, releve),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{module}")
    public ResponseEntity<String> deleteRelve(@PathVariable(name = "module") String module) throws RessourceNotFoundException {
        this.releveService.deleteModule(module);
        return new ResponseEntity<>("delete successfully",HttpStatus.ACCEPTED);
    }
}
