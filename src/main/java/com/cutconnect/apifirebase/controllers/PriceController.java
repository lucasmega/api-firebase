package com.cutconnect.apifirebase.controllers;

import com.cutconnect.apifirebase.domains.dto.CostDTO;
import com.cutconnect.apifirebase.services.PriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/price")
@RestController
public class PriceController {
    private static final Logger logger = LoggerFactory.getLogger(PriceController.class);
    private final PriceService priceService;
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @RequestMapping(value = "/find-price-by-account", method = RequestMethod.GET)
    public ResponseEntity<List<CostDTO>> findPriceByAccout() {
        try {
            return ResponseEntity.ok(priceService.findPriceByAccout());
        } catch (Exception e) {
            throw new IllegalArgumentException("Não foi possível buscar o preços");
        }
    }

}
