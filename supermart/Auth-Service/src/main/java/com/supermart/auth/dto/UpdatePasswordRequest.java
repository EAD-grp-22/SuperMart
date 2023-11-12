package com.supermart.auth.dto;

import lombok.Data;

@Data
public class UpdatePasswordRequest {
    private String email;
    private String currentPassword;
    private String newPassword;
}
