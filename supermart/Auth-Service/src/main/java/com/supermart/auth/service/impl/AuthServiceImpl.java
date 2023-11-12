package com.supermart.auth.service.impl;

import com.supermart.auth.dto.*;

import com.supermart.auth.model.Role;
import com.supermart.auth.model.User;
import com.supermart.auth.repository.UserRepository;
import com.supermart.auth.service.AuthService;
import com.supermart.auth.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;


    public User signup(SignUpRequest signUpRequest){
        if (userRepository.findByEmail(signUpRequest.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email is already registered");
        }
        User user=new User();
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signUpRequest.getHashedPassword()));
        user.setRole(signUpRequest.getRole());
        return userRepository.save(user);
    }


    public JwtAuthenticationResponse signin(SignInRequest signInRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getEmail(),signInRequest.getPassword())
        );
        var user=userRepository.findByEmail(signInRequest.getEmail())
                .orElseThrow(()->new IllegalArgumentException("Invalid email or password"));
        var jwt=jwtService.generateToken(user);
        var refreshToken=jwtService.generateRefreshToken(new HashMap<>(),user);

        JwtAuthenticationResponse jwtAuthenticationResponse=new JwtAuthenticationResponse();
        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);
        return jwtAuthenticationResponse;
    }

    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest){
        String userEmail=jwtService.extractUserName(refreshTokenRequest.getToken());
        User user=userRepository.findByEmail(userEmail).orElseThrow();
        if(jwtService.isTokenValid(refreshTokenRequest.getToken(),user)){
            var jwt=jwtService.generateToken(user);

            JwtAuthenticationResponse jwtAuthenticationResponse=new JwtAuthenticationResponse();
            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());
            return jwtAuthenticationResponse;
        }
        return null;
    }


    public Role extractUserRole(GetRoleRequest getRoleRequest) {
        String userEmail=jwtService.extractUserName(getRoleRequest.getToken());
        User user=userRepository.findByEmail(userEmail).orElseThrow();
        if(jwtService.isTokenValid(getRoleRequest.getToken(),user)){
            var role=user.getRole();
            return role;
        }
        return null;
    }

    public String updateEmail(UpdateEmailRequest updateEmailRequest) {
        Optional<User> userOptional = userRepository.findByEmail(updateEmailRequest.getCurrentEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setEmail(updateEmailRequest.getNewEmail());
            userRepository.save(user);
            return "Email updated successfully";
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public String updatePassword(UpdatePasswordRequest updatePasswordRequest) {
        Optional<User> userOptional = userRepository.findByEmail(updatePasswordRequest.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(updatePasswordRequest.getCurrentPassword(), user.getPassword())) {
                user.setPassword(passwordEncoder.encode(updatePasswordRequest.getNewPassword()));
                userRepository.save(user);
                return "Password updated successfully";
            } else {
                throw new RuntimeException("Current password is incorrect");
            }
        } else {
            throw new RuntimeException("User not found");
        }
    }

}
