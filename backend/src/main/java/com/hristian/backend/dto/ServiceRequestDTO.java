package com.hristian.backend.dto;

public class ServiceRequestDTO {

    private String name;

    private double price;

    private long mechanicId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(long mechanicId) {
        this.mechanicId = mechanicId;
    }
}
