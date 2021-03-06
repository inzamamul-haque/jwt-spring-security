package com.inzamamul.security.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "acl_user")
@EntityListeners(AuditingEntityListener.class)
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(targetEntity = Role.class)
    private Set<Role> roles;
    private String username;
    private String password;

}
