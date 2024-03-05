package com.cutconnect.apifirebase.controllers;

import com.cutconnect.apifirebase.domains.dto.ProfessionalDTO;
import com.cutconnect.apifirebase.services.BarberShopService;
import com.cutconnect.apifirebase.services.ProfessionalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/professional")
@RestController
public class ProfessionalController {

    private static final Logger logger = LoggerFactory.getLogger(ProfessionalController.class);


    private final ProfessionalService professionalService;

    @Autowired
    ProfessionalController(ProfessionalService professionalService) {
        this.professionalService = professionalService;
    }

    @RequestMapping(value = "/find-all", method = RequestMethod.GET)
    public ResponseEntity<List<ProfessionalDTO>> findAll() {
        try {
            return ResponseEntity.ok(this.professionalService.findAll());
        } catch (Exception e) {
            throw new IllegalArgumentException("Não foi possível buscar os profissionais: ", e);
        }
    }
}
