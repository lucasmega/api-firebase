package com.cutconnect.apifirebase.controllers;

import com.cutconnect.apifirebase.domains.dto.ProductDataDTO;
import com.cutconnect.apifirebase.domains.dto.ProductWithPriceDTO;
import com.cutconnect.apifirebase.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/find-products-by-email", method = RequestMethod.GET)
    public ResponseEntity<List<ProductWithPriceDTO>> findProductsByEmail() {
        try {
            return ResponseEntity.ok(productService.findProductsByEmail());
        } catch (Exception e) {
            throw new IllegalArgumentException("Não foi possível buscar os produtos com preços: ", e);
        }
    }

    @RequestMapping(value = "/find-products-by-account", method = RequestMethod.GET)
    public ResponseEntity<List<ProductDataDTO>> findProductsByAccount() {
        try {
            return ResponseEntity.ok(productService.findProductsByAccount());
        } catch (Exception e) {
            throw new IllegalArgumentException("Não foi possível buscar os produtos: ", e);
        }
    }
}
