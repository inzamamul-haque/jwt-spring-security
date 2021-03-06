package com.inzamamul.security.controller;

import com.inzamamul.security.dto.request.SignInRequest;
import com.inzamamul.security.dto.request.SignUpRequest;
import com.inzamamul.security.dto.request.UserRoleRequest;
import com.inzamamul.security.dto.response.JwtResponse;
import com.inzamamul.security.entity.User;
import com.inzamamul.security.service.AuthenticationService;
import com.inzamamul.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("public/")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserService userService;

    @PostMapping("signIn")
    public JwtResponse authenticateUser(@RequestBody SignInRequest signInRequest) {
        return authenticationService.signIn(signInRequest);
    }

    @PostMapping("signUp")
    public ResponseEntity<String> registerUser(@RequestBody SignUpRequest signUpRequest) {
        try {
            return authenticationService.signUp(signUpRequest);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/createNewRole")
    public ResponseEntity<String> createNewRole(@RequestBody UserRoleRequest userRoleRequest) {
        return userService.createNewRole(userRoleRequest);
    }


}
