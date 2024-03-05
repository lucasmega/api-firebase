package com.cutconnect.apifirebase.controllers;

import com.cutconnect.apifirebase.domains.dto.BranchDTO;
import com.cutconnect.apifirebase.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(value = "/branch")
public class BranchController {

    private final BranchService branchService;

    @Autowired
    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @RequestMapping(value = "/find-all", method = RequestMethod.GET)
    public ResponseEntity<List<BranchDTO>> findAll() {
        try {
            return ResponseEntity.ok(this.branchService.findAll());
        } catch (Exception e) {
            throw new IllegalArgumentException("Não foi possível buscar as filias da barbearia: ", e);
        }
    }

    @RequestMapping(value = "/find-by-id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Mono<BranchDTO>> findById(@PathVariable("id") String id) {
        try {
            return ResponseEntity.ok(this.branchService.findById(id));
        } catch (Exception e) {
            throw new IllegalArgumentException("Não foi possível buscar filial: " + e);
        }
    }


}
