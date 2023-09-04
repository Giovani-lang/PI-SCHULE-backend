package com.logonedigital.PI.SCHULE.Controller;


import com.logonedigital.PI.SCHULE.Service.Interface.IUserService;
import com.logonedigital.PI.SCHULE.dto.user_dto.UserRequest;
import com.logonedigital.PI.SCHULE.dto.user_dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> addUser (@RequestBody UserRequest user){
        return new ResponseEntity<>(this.userService.addUser(user), HttpStatus.CREATED);
    }
    @GetMapping("{email}")
    public ResponseEntity<UserResponse> getUser (@PathVariable(name = "email") String email){
        return new ResponseEntity<>(this.userService.getUser(email), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUser (){
        return new ResponseEntity<>(this.userService.getAllUser(), HttpStatus.OK);
    }
    @PutMapping("{email}")
    public ResponseEntity<UserResponse> editUser (@PathVariable(name = "email") String email,@RequestBody UserRequest user){
        return new ResponseEntity<>(this.userService.editUser(email,user), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("{email}")
    public ResponseEntity<String> deleteUser (@PathVariable(name = "email") String email){
        this.userService.deleteUser(email);
        return new ResponseEntity<>("Delete successfully", HttpStatus.ACCEPTED);
    }

}
