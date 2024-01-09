package com.logonedigital.PI.SCHULE.Controller;

import com.logonedigital.PI.SCHULE.Service.Interface.IUserService;
import com.logonedigital.PI.SCHULE.dto.login_dto.LoginDTO;
import com.logonedigital.PI.SCHULE.dto.user_dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginDTO loginDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new ResponseEntity<>(this.userService.getUser(loginDto.getEmail()), HttpStatus.OK);
    }


}

