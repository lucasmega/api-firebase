package com.cutconnect.apifirebase.controllers;
import com.cutconnect.apifirebase.domains.DTO.BarberShopDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cutconnect.apifirebase.services.BarberShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BarberShopController {

    private static final Logger logger = LoggerFactory.getLogger(BarberShopService.class);

    private BarberShopService barberShopService;

    @Autowired
    BarberShopController(BarberShopService barberShopService) {
        this.barberShopService = barberShopService;
    }

    @GetMapping("find-all")
    public ResponseEntity<List<BarberShopDTO>> findAll() {
        try {
            return ResponseEntity.ok(this.barberShopService.findAll());
        } catch (Exception e) {
            logger.error("Error" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
