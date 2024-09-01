package com.hristian.backend.repository;

import com.hristian.backend.model.User;
import com.hristian.backend.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    boolean existsByVin(String vin);
    boolean existsByLicensePlate(String licensePlate);
}
