package com.cutconnect.apifirebase.securities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.AuthenticationProvider;

import com.cutconnect.apifirebase.domains.TokenModel;
import com.cutconnect.apifirebase.configuration.FirebaseConfig;

@Component
public class FirebaseProvider implements AuthenticationProvider {

    private static final Logger logger = LoggerFactory.getLogger(FirebaseConfig.class);

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return TokenModel.class.isAssignableFrom(authentication);
    }
}
