package com.cutconnect.apifirebase.services;

import com.cutconnect.apifirebase.domains.dto.BarberShopDTO;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.util.List;

@Service
public class BarberShopService {
    private static final Logger logger = LoggerFactory.getLogger(BarberShopService.class);
    private final WebClient webClient;
    public BarberShopService(@Value("${domain.key}") String domain) {
        this.webClient = WebClient.create(domain + "/barbershop");
    }
    public List<BarberShopDTO> findAll() {

        List<BarberShopDTO> result = webClient.get()
                .uri("/find-all")
                .retrieve()
                .bodyToFlux(BarberShopDTO.class)
                .collectList()
                .block();

        return result;
    }
    public List<BarberShopDTO> findByPartialName(String partialName) {
        return webClient.get()
                .uri("/find-by-partial-name/" + partialName)
                .retrieve()
                .bodyToFlux(BarberShopDTO.class)
                .collectList()
                .block();
    }
}
