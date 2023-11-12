package com.supermart.user.service;

import com.supermart.user.dto.SignUpRequest;
import com.supermart.user.dto.UpdateEmailRequest;

public interface CallAuthAPIService {
    boolean signupRequest(SignUpRequest signUpRequest);
    boolean updateEmailRequest(UpdateEmailRequest updateEmailRequest);
}
