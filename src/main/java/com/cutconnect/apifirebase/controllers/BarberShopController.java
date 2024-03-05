package com.cutconnect.apifirebase.controllers;
import com.cutconnect.apifirebase.domains.dto.BarberShopDTO;
import com.cutconnect.apifirebase.domains.dto.ProfessionalDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cutconnect.apifirebase.services.BarberShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/barbershop")
@RestController
public class BarberShopController {

    private static final Logger logger = LoggerFactory.getLogger(BarberShopService.class);

    private final BarberShopService barberShopService;

    @Autowired
    BarberShopController(BarberShopService barberShopService) {
        this.barberShopService = barberShopService;
    }

    @RequestMapping(value = "/find-all", method = RequestMethod.GET)
    public ResponseEntity<List<BarberShopDTO>> findAll() {
        try {
            return ResponseEntity.ok(this.barberShopService.findAll());
        } catch (Exception e) {
            throw new IllegalArgumentException("Não foi possível buscar encontrar as barbearias" + e);
        }
    }

    @RequestMapping(value = "/find-by-partial-name/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<BarberShopDTO>> findByPartialName(@PathVariable("name") String name) {
        try {
            return ResponseEntity.ok(this.barberShopService.findByPartialName(name));
        } catch (Exception e) {
            throw new IllegalArgumentException("Não foi possível buscar encontrar as barbearias" + e);
        }
    }
}
