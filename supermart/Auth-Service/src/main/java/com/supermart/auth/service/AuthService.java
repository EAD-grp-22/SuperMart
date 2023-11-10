package com.supermart.auth.service;

import com.supermart.auth.dto.SignUpRequest;
import com.supermart.auth.model.User;

public interface AuthService {
    public User signup(SignUpRequest signUpRequest);
}
