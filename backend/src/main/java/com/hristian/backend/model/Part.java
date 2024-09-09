package com.hristian.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Min(0)
    private double unitPrice;

    private int quantity;

    private boolean isDeleted;

    @ManyToMany(mappedBy = "parts")
    private Set<Vehicle> vehicles = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Min(0)
    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(@Min(0) double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
