package com.cutconnect.apifirebase.domains.form;

public class UserForm {
    private String id;
    private String email;
    private String barbershopId;
    private String accountId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBarbershopId() {
        return barbershopId;
    }

    public void setBarbershopId(String barbershopId) {
        this.barbershopId = barbershopId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
