package com.cutconnect.apifirebase.services;

import com.cutconnect.apifirebase.controllers.AuthenticationController;
import com.cutconnect.apifirebase.domains.dto.ProductDataDTO;
import com.cutconnect.apifirebase.domains.dto.ProductWithPriceDTO;
import com.cutconnect.apifirebase.domains.form.FavoriteBarbershop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);


    private final WebClient webClient;
    private final UserService userService;

    public ProductService(@Value("${domain.key}") String domain, UserService userService) {
        this.webClient = WebClient.create(domain + "/product");
        this.userService = userService;
    }

    public List<ProductWithPriceDTO> findProductsByEmail() {
        FavoriteBarbershop user = userService.getUser();

        return webClient.post()
                .uri("/find-products-by-email")
                .bodyValue(user.getEmail())
                .retrieve()
                .bodyToMono(List.class)
                .block();

    }
    public List<ProductDataDTO> findProductsByAccount() {
        return webClient.get()
                .uri("/get-all-products")
                .retrieve()
                .bodyToFlux(ProductDataDTO.class)
                .collectList()
                .block();
    }
}
