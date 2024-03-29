package com.tuvarna.delivery.gui.service;

import com.tuvarna.delivery.authentication.payload.request.LoginRequestDTO;
import com.tuvarna.delivery.authentication.payload.request.SignUpRequestDTO;
import com.tuvarna.delivery.jwt.JWTAuthenticationResponse;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class AuthService {
    public ResponseEntity<JWTAuthenticationResponse> fetchSignIn(LoginRequestDTO requestDTO) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<LoginRequestDTO> request = new HttpEntity<>(requestDTO, headers);
        return restTemplate.exchange(
                "http://localhost:443/api/v1/auth/signin",
                HttpMethod.POST,
                request,
                JWTAuthenticationResponse.class);
    }

    public ResponseEntity<String> fetchSignUp(SignUpRequestDTO requestDTO) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SignUpRequestDTO> request = new HttpEntity<>(requestDTO, headers);
        return restTemplate.exchange(
                "http://localhost:443/api/v1/auth/signup?type=USER",
                HttpMethod.POST,
                request,
                String.class);
    }
}
