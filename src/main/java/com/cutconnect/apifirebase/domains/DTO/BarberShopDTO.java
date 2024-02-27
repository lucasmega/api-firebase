package com.cutconnect.apifirebase.domains.DTO;


import java.util.List;
import java.util.UUID;

public class BarberShopDTO {

    private String id = UUID.randomUUID().toString();
    private String name;
    private List<ProfessionalDTO> professionals;

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
    public List<ProfessionalDTO> getProfessionals() {
        return professionals;
    }
    public void setProfessionals(List<ProfessionalDTO> professionals) {
        this.professionals = professionals;
    }
}
