package com.oniesoft.controller;

import com.oniesoft.jwtresponse.AuthenticationResponse;
import com.oniesoft.model.AdminRegister;
import com.oniesoft.repository.AdminRegisterRepo;
import com.oniesoft.service.LoginService;
import com.oniesoft.serviceimpl.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login/v1")
public class LoginController {
    @Autowired
    AdminRegisterRepo adminRegisterRepo;
    @Autowired
    LoginService loginService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticateAndGetToken(@RequestBody AdminRegister authRequest) {
        String email = authRequest.getEmail();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            AdminRegister userRole = adminRegisterRepo.findByEmail(email);

            String role = (userRole != null) ? userRole.getRoles() : "";

            final String jwt = jwtService.generateToken(authRequest.getEmail());

            // Create an instance of AuthenticationResponse and return it in the ResponseEntity
            AuthenticationResponse response = new AuthenticationResponse(jwt, role);
            return ResponseEntity.ok(response);
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }
}
