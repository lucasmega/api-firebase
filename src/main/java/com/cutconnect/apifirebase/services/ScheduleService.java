package com.cutconnect.apifirebase.services;

import java.util.List;
import reactor.core.publisher.Mono;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.cutconnect.apifirebase.exceptions.ErrorResponse;
import com.cutconnect.apifirebase.exceptions.BusinessException;
import com.cutconnect.apifirebase.domains.form.FavoriteBarbershop;
import com.cutconnect.apifirebase.domains.form.ScheduleFromBarbershop;

@Service
public class ScheduleService {
    private final WebClient webClient;
    private final UserService userService;
    ScheduleService(@Value("${domain.key}") String domain, UserService userService) {
        this.webClient = WebClient.create(domain + "/schedule");
        this.userService = userService;
    }
    public List<String> findHourByDateFromBarbershop(ScheduleFromBarbershop object) {

        FavoriteBarbershop user = userService.getUser();
        object.setEmail(user.getEmail());

        return webClient.post()
                .uri("/find-hour-by-date-from-barbershop")
                .bodyValue(object)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, response -> {
                    return response.bodyToMono(ErrorResponse.class)
                            .flatMap(error -> Mono.error(new BusinessException(error.getMessage())));
                })
                .onStatus(HttpStatus::is5xxServerError, response -> {
                    return response.bodyToMono(ErrorResponse.class)
                            .flatMap(error -> Mono.error(new BusinessException(error.getMessage())));
                })
                .bodyToMono(List.class)
                .onErrorResume(WebClientResponseException.class, e -> {
                    return Mono.error(new BusinessException("Erro de comunicação: " + e.getMessage()));
                })
                .block();
    }
}
