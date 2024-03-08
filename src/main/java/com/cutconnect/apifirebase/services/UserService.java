package com.cutconnect.apifirebase.services;

import com.cutconnect.apifirebase.domains.dto.BarberShopDTO;
import com.cutconnect.apifirebase.domains.form.FavoriteBarbershop;
import com.cutconnect.apifirebase.domains.form.UserForm;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final WebClient webClient;

    UserService(@Value("${domain.key}") String domain) {
        this.webClient = WebClient.create(domain + "/user");
    }

    public void addFavoriteBarbershop(BarberShopDTO barberShop) {

        FavoriteBarbershop user = getUser();
        user.setBarbershopId(barberShop.getId());

        webClient.post()
                .uri("/add-favorite-barbershop")
                .body(Mono.just(user), FavoriteBarbershop.class)
                .retrieve()
                .toBodilessEntity()
                .block();
    }


    public FavoriteBarbershop getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        try {
            if (authentication != null && authentication.isAuthenticated()) {
                UserRecord userRecord = FirebaseAuth.getInstance().getUser((String) authentication.getPrincipal());

                FavoriteBarbershop object = new FavoriteBarbershop();

                object.setUid(userRecord.getUid());
                object.setEmail(userRecord.getEmail());
                object.setName(userRecord.getDisplayName());

                return object;
            }
            throw new IllegalArgumentException("Não foi possível obter usuário logado!");

        } catch (Exception e) {
            throw new IllegalArgumentException("Não foi possível obter usuário logado: " + e);
        }
    }

    public void save(UserForm userForm) {

        FavoriteBarbershop user = getUser();
        userForm.setEmail(user.getEmail());
        userForm.setId(user.getUid());

        webClient.post()
                .uri("/create")
                .body(Mono.just(userForm), UserForm.class)
                .retrieve()
                .toBodilessEntity()
                .block();
    }


}
