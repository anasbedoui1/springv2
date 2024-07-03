package com.example.travelreservation.service;

import com.example.travelreservation.dto.LoginRequest;
import com.example.travelreservation.dto.RegistrationRequest;
import com.example.travelreservation.model.User;
import com.example.travelreservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User registerUser(RegistrationRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setRole("USER");

        return userRepository.save(user);
    }

    public User authenticateUser(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername());
        if (user != null && bCryptPasswordEncoder.matches(request.getPassword(), user.getPassword())) {
            return user;
        }
        return null;
    }

    // Implement JWT generation methods
}
