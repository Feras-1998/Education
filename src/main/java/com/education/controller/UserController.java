package com.education.controller;

import com.education.config.JwtUtils;
import com.education.dta.AuthenticationRequest;
import com.education.dta.AuthenticationResponse;
import com.education.model.User;
import com.education.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("apis/users")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @PutMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        customUserDetailsService.register(user);
        return ResponseEntity.ok("User registered successfully");
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
        );

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        String token = jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

}
