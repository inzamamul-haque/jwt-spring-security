package com.inzamamul.security.Entity;

import lombok.Data;

import java.util.List;

@Data
public class User {
    String id;
    String name;
    List<Role> roles;
    String username;
    String password;
}
