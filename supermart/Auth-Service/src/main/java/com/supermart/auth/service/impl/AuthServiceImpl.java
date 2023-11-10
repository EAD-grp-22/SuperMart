package com.supermart.auth.service.impl;

import com.supermart.auth.dto.SignUpRequest;

import com.supermart.auth.model.User;
import com.supermart.auth.repository.UserRepository;
import com.supermart.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User signup(SignUpRequest signUpRequest){
        User user=new User();
        user.setEmail(signUpRequest.getEmail());
        user.setHashedPassword(passwordEncoder.encode(signUpRequest.getHashedPassword()));
        user.setRole(signUpRequest.getRole());

        return userRepository.save(user);
    }



}
