package com.cutconnect.apifirebase.services;

import com.cutconnect.apifirebase.domains.dto.ProfessionalDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ProfessionalService {

    private final WebClient webClient;

    public ProfessionalService(@Value("${domain.key}") String domain) {
        this.webClient = WebClient.create(domain + "/professional");
    }

    public List<ProfessionalDTO> findAll() {
        return webClient.get()
                .uri("/find-all")
                .retrieve()
                .bodyToFlux(ProfessionalDTO.class)
                .collectList()
                .block();
    }
}
