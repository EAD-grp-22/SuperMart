package com.supermart.user.service;

import com.supermart.user.dto.UserResponse;
import com.supermart.user.model.User;

import java.util.List;

public interface UserMapperService {
    UserResponse mapToUserResponse(User user);
    List<UserResponse> mapToUserResponseList(List<User> userList);
}
