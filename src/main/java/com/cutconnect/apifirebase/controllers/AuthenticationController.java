package com.cutconnect.apifirebase.controllers;

import com.cutconnect.apifirebase.domains.MessageDTO;
import com.cutconnect.apifirebase.domains.User;
import com.cutconnect.apifirebase.services.FirebaseAuthenticationService;
import com.google.firebase.auth.FirebaseAuthException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    FirebaseAuthenticationService service;

    @GetMapping("/hello")
    public ResponseEntity<MessageDTO> getHello() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(new MessageDTO("Hello " + username + "from spring boot"));
    }

    @GetMapping("/create-user")
    public ResponseEntity<?> createUser() {
        try {
            return ResponseEntity.ok(service.createUser());
        } catch (FirebaseAuthException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Error " + e.toString());
        }
    }
}
