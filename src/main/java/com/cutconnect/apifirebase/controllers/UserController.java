package com.cutconnect.apifirebase.controllers;

import com.cutconnect.apifirebase.domains.form.UserForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cutconnect.apifirebase.services.UserService;
import com.cutconnect.apifirebase.domains.dto.BarberShopDTO;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping(value = "/add-favorite-barbershop", method = RequestMethod.POST)
    public ResponseEntity<Void> addFavoriteBarbershop(@RequestBody BarberShopDTO object) {
        try {
            userService.addFavoriteBarbershop(object);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new IllegalArgumentException("Não foi possível favoritar a barbearia");
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ResponseEntity<Void> save() {
        try {
            this.userService.save(new UserForm());
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new IllegalArgumentException("Não foi possível criar o usuário" + e);
        }
    }
}
