package com.logonedigital.PI.SCHULE.Controller;

import com.logonedigital.PI.SCHULE.Entity.Role;
import com.logonedigital.PI.SCHULE.Service.Interface.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/roles")
@RestController
@RequiredArgsConstructor
public class RoleController  {

    private final IRoleService roleService;
    @PostMapping
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        return new ResponseEntity<>(this.roleService.addRole(role), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Role> getRole(@PathVariable(name = "id") Integer id) {
        return new ResponseEntity<>(this.roleService.getRole(id),HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<Role>> getRoles() {
        return new ResponseEntity<>(this.roleService.getRoles(),HttpStatus.ACCEPTED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Role> updateRle(@PathVariable(name = "id") Integer id, @RequestBody Role role) {
        return new ResponseEntity<>(this.roleService.updateRle(id,role),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRole(Integer id) {
        return new ResponseEntity<>("delete successfully", HttpStatus.OK);
    }
}
