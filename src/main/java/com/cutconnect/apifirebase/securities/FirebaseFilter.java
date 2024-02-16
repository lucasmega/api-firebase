package com.cutconnect.apifirebase.securities;

import com.cutconnect.apifirebase.domains.TokenModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirebaseFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(FirebaseFilter.class);

//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        try {
//            String token = getToken(request);
//            if (token != null)
//                SecurityContextHolder.getContext().setAuthentication(new TokenModel(token));
//            logger.info("TOKEN =>" + token);
//        } catch (Exception e) {
//            logger.error("Fail in do filter: ", e.getMessage());
//        }
//
//        filterChain.doFilter(request, response);
//    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        FirebaseToken decodedToken = null;

        String path = request.getRequestURI();

        try {
            String token = getToken(request);
            decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);

        } catch (FirebaseAuthException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Error " + e.toString());
        }

        if(decodedToken == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token inválido");
        }

        chain.doFilter(request, response);
    }


    private String getToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            return header.replace("Bearer ", "");
        }
        return null;
    }

}
