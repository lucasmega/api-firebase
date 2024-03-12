package com.cutconnect.apifirebase.services;

import com.cutconnect.apifirebase.domains.dto.CostDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class PriceService {
    private final WebClient webClient;

    private PriceService(@Value("${domain.key}") String domain) {
        this.webClient = WebClient.create(domain + "/price");
    }

    public List<CostDTO> findPriceByAccout() {
        return webClient.get()
                .uri("/get-all-princing")
                .retrieve()
                .bodyToFlux(CostDTO.class)
                .collectList()
                .block();
    }
}
