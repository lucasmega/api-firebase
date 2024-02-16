package com.cutconnect.apifirebase.domains;

import org.springframework.security.authentication.AbstractAuthenticationToken;


public class TokenModel extends AbstractAuthenticationToken {

    private String token;
    public TokenModel(String token) {
        super(null);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.token;
    }
}
