package com.logonedigital.PI.SCHULE.Controller;

import com.logonedigital.PI.SCHULE.Entity.Administration;
import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Service.Interface.AdminService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/administrations")
public class AdminController {
    private final AdminService adminService;
    public AdminController(AdminService adminService){
        this.adminService= adminService;
    }
@PostMapping
public ResponseEntity<Administration> addAdministration(@RequestBody@Valid Administration administration) throws RessourceNotFoundException {
        return new ResponseEntity<>( this.adminService.addAdministration(administration), HttpStatus.CREATED);
}
    @GetMapping
    public List<Administration> getAdministrations() {
        return this.adminService.getAdministrations();
    }
    @GetMapping("{email}")
    public ResponseEntity<Administration> getAdministration(@PathVariable(name = "email")String email) throws RessourceNotFoundException {
     return new ResponseEntity<>(this.adminService.getAdministration(email), HttpStatus.OK);
    }
@DeleteMapping("{email}")
    public ResponseEntity <String> deleteAdministration(@PathVariable(name = "email")String email)throws RessourceNotFoundException{
        this.adminService.deleteAdministration(email);
        return new ResponseEntity<>("Administration deleted successfully", HttpStatus.ACCEPTED);
}
@PutMapping("{email}")
    public ResponseEntity<Administration> updateAdministration(@PathVariable(name = "email") String email,
                                                               @RequestBody Administration administration) throws RessourceNotFoundException{
        return new ResponseEntity<>(this.adminService.updateAdministration(administration, email), HttpStatus.ACCEPTED);
}

}
