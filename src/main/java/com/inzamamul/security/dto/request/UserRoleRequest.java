package com.inzamamul.security.dto.request;
import lombok.Data;

@Data
public class UserRoleRequest {
    private Long id;
    private String name;
    private String description;
}
