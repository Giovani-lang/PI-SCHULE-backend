package com.logonedigital.PI.SCHULE.Controller;


import com.logonedigital.PI.SCHULE.Entity.Option;
import com.logonedigital.PI.SCHULE.Service.Interface.IOptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/options")
public class OptionController {

    private final IOptionService optionService;

    @PostMapping("/add")
    public ResponseEntity<Option> addOption(@RequestBody Option option){
        return new ResponseEntity<>(this.optionService.addOption(option), HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Option>> getAllOption(){
        return new ResponseEntity<>(this.optionService.getOption(), HttpStatus.OK);
    }
    @GetMapping("/detail/{nom}")
    public ResponseEntity<Option> getByName(@PathVariable (name = "nom")String nom){
        return new ResponseEntity<>(this.optionService.getByName(nom), HttpStatus.OK);
    }
    @PutMapping("/edit/{nom}")
    public ResponseEntity<Option> updateOption(@PathVariable(name = "nom")String nom,@RequestBody Option option){
        return new ResponseEntity<>(this.optionService.updateOption(nom, option), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{nom}")
    public ResponseEntity<String> deleteOption(@PathVariable(name = "nom")String nom){
        this.optionService.deleteOption(nom);
        return new ResponseEntity<>("delete successfully", HttpStatus.OK);
    }
}
