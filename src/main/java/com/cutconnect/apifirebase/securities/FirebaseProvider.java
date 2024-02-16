package com.cutconnect.apifirebase.securities;


import com.cutconnect.apifirebase.configuration.FirebaseConfig;
import com.cutconnect.apifirebase.domains.TokenModel;
import com.cutconnect.apifirebase.domains.UserModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class FirebaseProvider implements AuthenticationProvider {

    private static final Logger logger = LoggerFactory.getLogger(FirebaseConfig.class);

/*
* Assossia o token ao usuário
* */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {

            TokenModel token = (TokenModel) authentication;
            FirebaseToken firebaseToken = FirebaseAuth.getInstance().verifyIdToken(token.getToken());
            String uid = firebaseToken.getUid();
            UserRecord userRecord = FirebaseAuth.getInstance().getUser(uid);
            UserModel authenticatedUser = new UserModel(userRecord);
            return new UsernamePasswordAuthenticationToken(authenticatedUser, token, authenticatedUser.getAuthorities());

        } catch (FirebaseAuthException e) {
            logger.error("Fail: {}", e.getAuthErrorCode());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return TokenModel.class.isAssignableFrom(authentication);
    }
}
