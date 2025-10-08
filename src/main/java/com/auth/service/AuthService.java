package com.auth.service;


import com.auth.dto.AuthenticationRequest;
import com.auth.dto.AuthenticationResponse;

public interface AuthService {

    AuthenticationResponse login(AuthenticationRequest authenticationRequest);
}
