package com.supermart.auth.dto;

import com.supermart.auth.model.Role;
import lombok.Data;

@Data
public class SignUpRequest {
    private String email;
    private String hashedPassword;
    private Role role;
}
