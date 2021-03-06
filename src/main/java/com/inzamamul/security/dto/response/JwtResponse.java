package com.inzamamul.security.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    private String token = "123456";
    private String type = "Bearer";

    public JwtResponse(String token) {
        this.token = token;
    }

}
