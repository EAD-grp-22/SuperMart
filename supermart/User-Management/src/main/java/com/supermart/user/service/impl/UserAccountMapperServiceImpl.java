package com.supermart.user.service.impl;

import com.supermart.user.dto.UserAccountResponse;
import com.supermart.user.model.UserAccount;
import com.supermart.user.service.UserAccountMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAccountMapperServiceImpl implements UserAccountMapperService {
    public UserAccountResponse mapToUserAccountResponse(UserAccount userAccount){
        return UserAccountResponse.builder()
                .email(userAccount.getEmail())
                .userName(userAccount.getUserName())
                .role(userAccount.getRole())
                .build();
    }
}
