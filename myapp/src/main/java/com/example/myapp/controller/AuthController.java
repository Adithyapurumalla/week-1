package com.example.myapp.controller;

import com.example.myapp.DTO.LoginRequest;
import com.example.myapp.DTO.SignupRequest;
import com.example.myapp.model.User;
import com.example.myapp.repo.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserRepository db;

    @PostMapping("/signup")
    public String signUp(@RequestBody SignupRequest sd) {

        
        if (db.findByEmail(sd.getEmail()).isPresent()) {
            return "Email already registered";
        }

        User user = new User();
        user.setName(sd.getName());
        user.setEmail(sd.getEmail());
        user.setPassword(sd.getPassword());
        db.save(user);

        return "Signup successful";
    }

    @PostMapping("/login")
    public String loginApi(@RequestBody LoginRequest loginData) {

        Optional<User> optionalUser = db.findByEmail(loginData.getEmail());

        if (optionalUser.isEmpty()) {
            return "User not found";
        }

        User user = optionalUser.get();

        if (!user.getPassword().equals(loginData.getPassword())) {
            return "Invalid password";
        }

        return "Login successful";
    }

}
