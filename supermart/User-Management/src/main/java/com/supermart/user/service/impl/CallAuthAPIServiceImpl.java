package com.supermart.user.service.impl;

import com.supermart.user.dto.SignUpRequest;
import com.supermart.user.dto.UpdateEmailRequest;
import com.supermart.user.service.CallAuthAPIService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class CallAuthAPIServiceImpl implements CallAuthAPIService {
    private final WebClient.Builder webClientBuilder;
    private final String authMicroServiceUrl="http://AUTH-MANAGEMENT/api/auth";

    @CircuitBreaker(name = "auth",fallbackMethod = "signupFallbackMethod")
    @Retry(name = "auth")
    public boolean signupRequest(SignUpRequest signUpRequest) {
        try {
            webClientBuilder.build()
                    .post()
                    .uri(authMicroServiceUrl + "/signup")
                    .bodyValue(signUpRequest)
                    .retrieve()
                    .toBodilessEntity()
                    .block();
            return true;
        } catch (Exception e){
            throw new RuntimeException("Error when making request to auth service");
        }
    }

    public boolean signupFallbackMethod(SignUpRequest signUpRequest, RuntimeException runtimeException){
        throw new RuntimeException("unable to signup user to auth server at the moment");
    }


    @CircuitBreaker(name = "auth",fallbackMethod = "updateFallbackMethod")
    @Retry(name = "auth")
    public boolean updateEmailRequest(UpdateEmailRequest updateEmailRequest) {
        try {
            webClientBuilder.build()
                    .patch()
                    .uri(authMicroServiceUrl + "/update/email")
                    .bodyValue(updateEmailRequest)
                    .retrieve()
                    .toBodilessEntity()
                    .block();
            return true;
        } catch (Exception e){
            throw new RuntimeException("Error when making request to delivery service");
        }
    }

    public boolean updateFallbackMethod(UpdateEmailRequest updateEmailRequest, RuntimeException runtimeException){
        throw new RuntimeException("unable to update user to auth server at the moment");
    }
}
