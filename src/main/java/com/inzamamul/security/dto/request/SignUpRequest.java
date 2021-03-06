package com.inzamamul.security.dto.request;

import lombok.Data;

import java.util.Set;

@Data
public class SignUpRequest {
    private String name;
    private String userName;
    private String password;
    private Set<UserRoleRequest> roles;
}
