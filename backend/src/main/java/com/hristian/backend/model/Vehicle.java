package com.hristian.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Visit> visits = new ArrayList<>();

    private String model;

    @Column(nullable = false, unique = true)
    @Pattern(regexp = "^[A-C, E, H, K, M, O, P, T, X, Y]{1,2}\\s?\\d{4}[A-C, E, H, K, M, O, P, T, X, Y]{2}$")
    private String licensePlate;

    @Column(nullable = false, unique = true)
    @Size(min = 17, max = 17)
    private String vin;

    @Column(nullable = false)
    @Min(1886)
    @Max(2024)
    private int creationYear;

/*
    @Column(nullable = false)
    @ElementCollection
    private List<LocalDate> dates;

    @OneToMany
    private Map<LocalDate, ServiceModel> serviceMap = new HashMap<>();

    @OneToMany
    private Map<LocalDate, Part> partMap = new HashMap<>();
 */

    private boolean isDeleted;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public @Pattern(regexp = "^[A-C, E, H, K, M, O, P, T, X, Y]{1,2}\\s?\\d{4}[A-C, E, H, K, M, O, P, T, X, Y]{2}$") String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(@Pattern(regexp = "^[A-C, E, H, K, M, O, P, T, X, Y]{1,2}\\s?\\d{4}[A-C, E, H, K, M, O, P, T, X, Y]{2}$") String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public @Size(min = 17, max = 17) String getVin() {
        return vin;
    }

    public void setVin(@Size(min = 17, max = 17) String vin) {
        this.vin = vin;
    }

    @Min(1886)
    @Max(2024)
    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(@Min(1886) @Max(2024) int creationYear) {
        this.creationYear = creationYear;
    }

    /*
    public List<LocalDate> getDates() {
        return dates;
    }

    public void setDates(List<LocalDate> dates) {
        this.dates = dates;
    }

    public Map<LocalDate, ServiceModel> getServiceMap() {
        return serviceMap;
    }

    public void setServiceMap(Map<LocalDate, ServiceModel> serviceMap) {
        this.serviceMap = serviceMap;
    }

    public Map<LocalDate, Part> getPartMap() {
        return partMap;
    }

    public void setPartMap(Map<LocalDate, Part> partMap) {
        this.partMap = partMap;
    }
    */

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
