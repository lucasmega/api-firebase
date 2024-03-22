package com.cutconnect.apifirebase.domains.dto;

import java.util.ArrayList;
import java.util.List;

public class BranchDTO {

    private String id;

    private String name;

    private AddressDTO address;

    private BarberShopDTO barbershop;

    private List<ProfessionalDTO> professionals = new ArrayList<>();

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

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public BarberShopDTO getBarbershop() {
        return barbershop;
    }

    public void setBarbershop(BarberShopDTO barbershop) {
        this.barbershop = barbershop;
    }

    public List<ProfessionalDTO> getProfessionals() {
        return professionals;
    }

    public void setProfessionals(List<ProfessionalDTO> professionals) {
        this.professionals = professionals;
    }
}
