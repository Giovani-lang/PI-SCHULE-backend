package com.logonedigital.PI.SCHULE.Controller;

import com.logonedigital.PI.SCHULE.Exception.RessourceNotFoundException;
import com.logonedigital.PI.SCHULE.Service.Interface.AdminService;
import com.logonedigital.PI.SCHULE.dto.admin_dto.AdminRequestDTO;
import com.logonedigital.PI.SCHULE.dto.admin_dto.AdminResponseDTO;
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
    @PostMapping("/add")
    public ResponseEntity<AdminResponseDTO> addAdministration(@RequestBody@Valid AdminRequestDTO administration) throws RessourceNotFoundException {
        return new ResponseEntity<>( this.adminService.addAdministration(administration), HttpStatus.CREATED);
}
    @GetMapping("/getAll")
    public ResponseEntity<List<AdminResponseDTO>> getAdministrations() {
        return new ResponseEntity<>(this.adminService.getAdministrations(),HttpStatus.OK);
    }
    @GetMapping("/detail/{email}")
    public ResponseEntity<AdminResponseDTO> getAdministration(@PathVariable(name = "email")String email) throws RessourceNotFoundException {
     return new ResponseEntity<>(this.adminService.getAdministration(email), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{email}")
    public ResponseEntity <String> deleteAdministration(@PathVariable(name = "email")String email)throws RessourceNotFoundException{
        this.adminService.deleteAdministration(email);
        return new ResponseEntity<>("Administration deleted successfully", HttpStatus.ACCEPTED);
}
    @PutMapping("/edit/{email}")
    public ResponseEntity<AdminResponseDTO> updateAdministration(@PathVariable(name = "email") String email,
                                                               @RequestBody AdminRequestDTO administration) throws RessourceNotFoundException{
        return new ResponseEntity<>(this.adminService.updateAdministration(administration, email), HttpStatus.ACCEPTED);
}

}
