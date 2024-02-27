package com.cutconnect.apifirebase.services;

import com.cutconnect.apifirebase.domains.DTO.BarberShopDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class BarberShopService {
    private static final Logger logger = LoggerFactory.getLogger(BarberShopService.class);

    private final WebClient webClient;
    public BarberShopService() {
        this.webClient = WebClient.create("http://localhost:4242/");
    }

    public List<BarberShopDTO> findAll() {

        List<BarberShopDTO> result = webClient.get()
                .uri("find-all")
                .retrieve()
                .bodyToFlux(BarberShopDTO.class)
                .collectList()
                .block();

        return result;
    }

}
