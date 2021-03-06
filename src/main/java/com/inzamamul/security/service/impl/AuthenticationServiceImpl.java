package com.inzamamul.security.service.impl;

import com.inzamamul.security.configuration.jwt.JwtTokenProvider;
import com.inzamamul.security.dto.request.SignInRequest;
import com.inzamamul.security.dto.request.SignUpRequest;
import com.inzamamul.security.dto.request.UserRoleRequest;
import com.inzamamul.security.dto.response.JwtResponse;
import com.inzamamul.security.entity.Role;
import com.inzamamul.security.entity.User;
import com.inzamamul.security.repository.RoleRepository;
import com.inzamamul.security.repository.UserRepository;
import com.inzamamul.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtTokenProvider jwtProvider;
    @Autowired
    AuthenticationManager authenticationManager;


    @Override
     public JwtResponse signIn(SignInRequest signInRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInRequest.getUserName(),
                        signInRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        return new JwtResponse(jwt);
    }
    @Override
    public ResponseEntity<String> signUp(SignUpRequest signUpRequest) {

        User user = new User();
        user.setUsername(signUpRequest.getUserName());
        user.setName(signUpRequest.getName());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
        Set<Role> roles = new HashSet<>();
        Set<UserRoleRequest> userRoleRequestList = signUpRequest.getRoles();
        if(userRoleRequestList.size()>0) {
            for(UserRoleRequest userRoleRequest: userRoleRequestList) {
                Optional<Role> roleOptional = roleRepository.findById(userRoleRequest.getId());
                Role role = roleOptional.get();
                roles.add(role);
            }
        }
        user.setRoles(roles);
        userRepository.save(user);

        return new ResponseEntity<String>("Successfully Created New User", HttpStatus.CREATED);
    }
}
