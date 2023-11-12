package com.supermart.user.service;

import com.supermart.user.dto.*;

import java.util.List;

public interface UserService {
    UserResponse getUserById(Integer id);
    List<UserResponse> getUsersByFirstName(String firstName);
    List<UserResponse> getUsersByLastName(String lastName);
    UserResponse getUserByEmail(String email);
    UserResponse getUserByUserName(String userName);
    String registerUser(RegisterUserRequest registerUserRequest);
    String updateUsername(UpdateUsernameRequest updateUsernameRequest);
    String removeUser(Integer userId);
    String updateEmail(UpdateEmailRequest updateEmailRequest);
    boolean checkUserValidity(Integer id);
}
