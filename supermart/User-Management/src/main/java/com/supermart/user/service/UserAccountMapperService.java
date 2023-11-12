package com.supermart.user.service;

import com.supermart.user.dto.UserAccountResponse;
import com.supermart.user.model.UserAccount;

public interface UserAccountMapperService {
    UserAccountResponse mapToUserAccountResponse(UserAccount userAccount);
}
