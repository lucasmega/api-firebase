package com.cutconnect.apifirebase.domains.dto;

import java.util.ArrayList;
import java.util.List;

public class BarberShopDTO {
    private String id;
    private String name;
    private String stripeId;
    private List<BranchDTO> branchs = new ArrayList<>();
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<BranchDTO> getBranchs() {
        return branchs;
    }
    public void setBranchs(List<BranchDTO> branchs) {
        this.branchs = branchs;
    }
    public String getStripeId() {
        return stripeId;
    }
    public void setStripeId(String stripeId) {
        this.stripeId = stripeId;
    }
}
