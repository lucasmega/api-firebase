package com.cutconnect.apifirebase.services;

import org.springframework.stereotype.Service;
import com.cutconnect.apifirebase.domains.dto.BranchDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class BranchService {

    private final WebClient webClient;

    @Autowired
    public BranchService(@Value("${domain.key}") String domain) {
        this.webClient = WebClient.create(domain + "/branch");
    }

    public List<BranchDTO> findAll() {
        List<BranchDTO> response = webClient.get()
                .uri("/find-all")
                .retrieve()
                .bodyToFlux(BranchDTO.class)
                .collectList()
                .block();

        return response;
    }

    public Mono<BranchDTO> findById(String id) {
        BranchDTO response = webClient.get()
                .uri("/find-by-id/{id}", id)
                .retrieve()
                .bodyToMono(BranchDTO.class)
                .block();

        return Mono.justOrEmpty(response);
    }


}
