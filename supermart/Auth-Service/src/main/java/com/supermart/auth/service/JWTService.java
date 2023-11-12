package com.supermart.auth.service;

import com.supermart.auth.model.Role;
import com.supermart.auth.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.Map;

public interface JWTService {
    String extractUserName(String token);
    String generateToken(UserDetails userDetails);
    boolean isTokenValid(String token,UserDetails userDetails);

    String generateRefreshToken(Map<String,Object> extraClaims, UserDetails userDetails);

}
