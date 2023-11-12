package com.supermart.auth.controller;

import com.supermart.auth.dto.*;
import com.supermart.auth.model.Role;
import com.supermart.auth.model.User;
import com.supermart.auth.service.AuthService;
import com.supermart.auth.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final JWTService jwtService;
    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authService.signup(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authService.signin(signInRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return ResponseEntity.ok(authService.refreshToken(refreshTokenRequest));
    }

    @PostMapping("/role")
    public Role getUserRoleFromToken(@RequestBody GetRoleRequest getRoleRequest) {
        return authService.extractUserRole(getRoleRequest);
    }

    @PatchMapping("/update/email")
    public String updateEmail(@RequestBody UpdateEmailRequest updateEmailRequest) {
        return authService.updateEmail(updateEmailRequest);
    }


    @PatchMapping("/update/password")
    public String changePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest) {
        return authService.updatePassword(updatePasswordRequest);
    }

}
