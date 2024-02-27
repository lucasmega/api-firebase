package com.cutconnect.apifirebase.domains.DTO;

import java.util.List;

public class ProfessionalDTO {
    private Long idProfessional;

    private String name;

    private BarberShopDTO barberShop;

    private List<ScheduleDTO> appointments;

    public Long getIdProfessional() {
        return idProfessional;
    }

    public void setIdProfessional(Long idProfessional) {
        this.idProfessional = idProfessional;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BarberShopDTO getBarberShop() {
        return barberShop;
    }

    public void setBarberShop(BarberShopDTO barberShop) {
        this.barberShop = barberShop;
    }

    public List<ScheduleDTO> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<ScheduleDTO> appointments) {
        this.appointments = appointments;
    }
}