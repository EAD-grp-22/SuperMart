package com.supermart.user.service;

import com.supermart.user.dto.SignUpRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class CallAuthAPIService {
    private final WebClient.Builder webClientBuilder;
    private final String authMicroServiceUrl="http://AUTH-MANAGEMENT/api/auth";

    @CircuitBreaker(name = "auth",fallbackMethod = "fallbackMethod")
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
            throw new RuntimeException("Error when making request to delivery service");
        }
    }

    public boolean fallbackMethod(SignUpRequest signUpRequest, RuntimeException runtimeException){
        throw new RuntimeException("unable to signup user to auth server at the moment");
    }
}
