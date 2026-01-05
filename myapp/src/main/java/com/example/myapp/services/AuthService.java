package com.example.myapp.services;

import com.example.myapp.DTO.AuthResponse;
import com.example.myapp.DTO.LoginRequest;
import com.example.myapp.DTO.SignupRequest;

public interface AuthService {

    AuthResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);
}
