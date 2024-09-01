package com.hristian.backend.dto;

import com.hristian.backend.model.Part;
import com.hristian.backend.model.ServiceModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VisitResponseDTO {
    private long vehicleId;
    private LocalDateTime date;
    private boolean isDeleted;
    //private List<Part> parts = new ArrayList<>();
    // private List<ServiceModel> services = new ArrayList<>();


    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
