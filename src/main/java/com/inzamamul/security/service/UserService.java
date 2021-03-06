package com.inzamamul.security.service;

import com.inzamamul.security.dto.request.UserRoleRequest;
import com.inzamamul.security.entity.Role;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<String> createNewRole(UserRoleRequest roleRequest);

}
