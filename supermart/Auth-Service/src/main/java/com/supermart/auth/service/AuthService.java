package com.supermart.auth.service;

import com.supermart.auth.dto.*;
import com.supermart.auth.model.Role;
import com.supermart.auth.model.User;

public interface AuthService {
    User signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signin(SignInRequest signInRequest);
    String updateEmail(UpdateEmailRequest updateEmailRequest);
    String updatePassword(UpdatePasswordRequest updatePasswordRequest);

    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

    public Role extractUserRole(GetRoleRequest getRoleRequest);
}
