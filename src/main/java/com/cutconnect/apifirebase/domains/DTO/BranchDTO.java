package com.cutconnect.apifirebase.domains.DTO;

public class BranchDTO {

    private Long idBranch;

    private String name;

    private BarberShopDTO barberShop;

    public Long getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Long idBranch) {
        this.idBranch = idBranch;
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
}
