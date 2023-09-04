package com.logonedigital.PI.SCHULE.Controller;

import com.logonedigital.PI.SCHULE.Entity.Releve;
import com.logonedigital.PI.SCHULE.Exception.RessourceExistException;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Service.Interface.IReleveService;
import com.logonedigital.PI.SCHULE.dto.releve_dto.ReleveRequest;
import com.logonedigital.PI.SCHULE.dto.releve_dto.ReleveResponse;
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
    public ResponseEntity<ReleveResponse> addReleve(@RequestBody @Valid ReleveRequest releve)throws RessourceExistException {
        return new ResponseEntity<>(this.releveService.addModule(releve), HttpStatus.CREATED);
    }

    @GetMapping("{module}")
    public ResponseEntity<ReleveResponse> getReleve(@PathVariable(name = "module") String module) throws RessourceNotFoundException {
        return new ResponseEntity<>(this.releveService.getModule(module),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ReleveResponse>> getReleves(){
        return new ResponseEntity<>(this.releveService.getModule(),HttpStatus.OK);
    }

    @PutMapping("{module}")
    public ResponseEntity<ReleveResponse> updateReleve(@PathVariable(name = "module") String module,
                                           @RequestBody ReleveRequest releve) throws RessourceNotFoundException{
        return new ResponseEntity<>(this.releveService.updateModule(module, releve),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{module}")
    public ResponseEntity<String> deleteRelve(@PathVariable(name = "module") String module) throws RessourceNotFoundException {
        this.releveService.deleteModule(module);
        return new ResponseEntity<>("delete successfully",HttpStatus.ACCEPTED);
    }
}
