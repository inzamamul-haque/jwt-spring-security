package com.inzamamul.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {

    @GetMapping("hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("getName")
    public ResponseEntity<String> getName() {
        return ResponseEntity.ok("Inzamamul");
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @GetMapping("hi")
    public ResponseEntity<String> hi() {
        return ResponseEntity.ok("hi");
    }


}
