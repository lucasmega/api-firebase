package com.cutconnect.apifirebase.domains.dto;

import java.util.List;

public class ProfessionalDTO {
    private String id;

    private String name;

    private String position;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}