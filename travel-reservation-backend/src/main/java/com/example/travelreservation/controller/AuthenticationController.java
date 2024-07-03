package com.example.travelreservation.controller;

import com.example.travelreservation.dto.LoginRequest;
import com.example.travelreservation.dto.RegistrationRequest;
import com.example.travelreservation.model.User;
import com.example.travelreservation.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public User registerUser(@RequestBody RegistrationRequest request) {
        return authenticationService.registerUser(request);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody LoginRequest request) {
        return authenticationService.authenticateUser(request);
    }
}
