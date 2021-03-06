package com.inzamamul.security.service;

import com.inzamamul.security.dto.request.SignInRequest;
import com.inzamamul.security.dto.request.SignUpRequest;
import com.inzamamul.security.dto.response.JwtResponse;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    JwtResponse signIn(SignInRequest signInRequest);
    ResponseEntity<String> signUp(SignUpRequest signUpRequest);
}
