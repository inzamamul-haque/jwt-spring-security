package com.inzamamul.security.service.impl;

import com.inzamamul.security.dto.request.UserRoleRequest;
import com.inzamamul.security.entity.Role;
import com.inzamamul.security.repository.RoleRepository;
import com.inzamamul.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public ResponseEntity<String> createNewRole(UserRoleRequest roleRequest) {
        Role role = new Role();
        role.setName(roleRequest.getName());
        role.setDescription(roleRequest.getDescription());
        roleRepository.save(role);
        return new ResponseEntity<String>("Created New Role Done",HttpStatus.CREATED);
    }
}
