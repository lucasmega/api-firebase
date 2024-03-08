package com.cutconnect.apifirebase.services;

import com.cutconnect.apifirebase.domains.dto.ProductWithPriceDTO;
import com.cutconnect.apifirebase.domains.form.FavoriteBarbershop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ProductService {

    private final WebClient webClient;
    private final UserService userService;

    @Autowired
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
}
