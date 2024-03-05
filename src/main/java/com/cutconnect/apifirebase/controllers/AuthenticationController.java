package com.cutconnect.apifirebase.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cutconnect.apifirebase.services.FirebaseAuthenticationService;

@RestController
@RequestMapping(value = "/user")
public class AuthenticationController {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    FirebaseAuthenticationService service;

    @RequestMapping(value = "/create-user", method = RequestMethod.GET)
    public ResponseEntity<?> createUser() {
        try {
            return ResponseEntity.ok(service.createUser());
        } catch (FirebaseAuthException e) {
            throw new IllegalArgumentException("Não foi possível criar o usuário");
        }
    }
}
