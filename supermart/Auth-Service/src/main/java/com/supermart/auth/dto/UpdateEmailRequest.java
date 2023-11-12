package com.supermart.auth.dto;

import lombok.Data;

@Data
public class UpdateEmailRequest {
    private String currentEmail;
    private String newEmail;
}
