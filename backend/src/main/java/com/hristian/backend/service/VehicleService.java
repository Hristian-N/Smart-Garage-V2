package com.hristian.backend.service;

import com.hristian.backend.dto.UserRequestDTO;
import com.hristian.backend.dto.UserResponseDTO;
import com.hristian.backend.dto.VehicleRequestDTO;
import com.hristian.backend.dto.VehicleResponseDTO;
import com.hristian.backend.exception.DuplicateEntryException;
import com.hristian.backend.exception.EntityNotFoundException;
import com.hristian.backend.mapper.VehicleMapper;
import com.hristian.backend.model.User;
import com.hristian.backend.model.Vehicle;
import com.hristian.backend.repository.UserRepository;
import com.hristian.backend.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;
    private final VehicleMapper vehicleMapper = VehicleMapper.INSTANCE;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository, UserRepository userRepository){
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
    }

    // Create
    public VehicleResponseDTO create(VehicleRequestDTO vehicleRequestDTO) {

        if (vehicleRepository.existsByVin(vehicleRequestDTO.getVin())) {
            throw new DuplicateEntryException("VIN already exists.");
        }

        if (vehicleRepository.existsByLicensePlate(vehicleRequestDTO.getLicensePlate())) {
            throw new DuplicateEntryException("License Plate already exists.");
        }

        Vehicle vehicle = vehicleMapper.vehicleRequestDTOToVehicle(vehicleRequestDTO);

        User user = userRepository.findById(vehicleRequestDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + vehicleRequestDTO.getUserId()));

        vehicle.setUser(user);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        return vehicleMapper.vehicleToVehicleResponseDTO(savedVehicle);
    }


    // Read
    public List<VehicleResponseDTO> getAll() {

        List<Vehicle> vehicles = vehicleRepository.findAll()
                .stream()
                .filter(vehicle -> !vehicle.isDeleted())
                .collect(Collectors.toList());
        return vehicleMapper.vehicleToVehicleResponseDTO(vehicles);
    }

    public VehicleResponseDTO getById(Long id) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);

        if (!vehicleOptional.isPresent() || vehicleOptional.get().isDeleted()) {
            throw new EntityNotFoundException("Vehicle not found with id " + id);
        }

        Vehicle vehicle = vehicleOptional.get();
        return vehicleMapper.vehicleToVehicleResponseDTO(vehicle);
    }

    // Update
    public VehicleResponseDTO update(Long id, VehicleRequestDTO vehicleRequestDTO) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);

        if (!vehicleOptional.isPresent() || vehicleOptional.get().isDeleted()) {
            throw new EntityNotFoundException("Vehicle not found with id " + id);
        }

        Vehicle vehicle = vehicleOptional.get();

        // Update code
        vehicle.setModel(vehicleRequestDTO.getModel());
        vehicle.setLicensePlate(vehicleRequestDTO.getLicensePlate());
        vehicle.setVin(vehicleRequestDTO.getVin());
        vehicle.setCreationYear(vehicleRequestDTO.getCreationYear());

        User user = userRepository.getReferenceById(vehicleRequestDTO.getUserId());
        vehicle.setUser(user);

        /*
            @Column(nullable = false)
            @ElementCollection
            private List<LocalDate> dates;

            @OneToMany
            private Map<LocalDate, Service> serviceMap = new HashMap<>();

            @OneToMany
            private Map<LocalDate, Part> partMap = new HashMap<>();
         */

        return vehicleMapper.vehicleToVehicleResponseDTO(vehicleRepository.save(vehicle));
    }

    // Delete
    public void delete(Long id) {

        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);

        if (!vehicleOptional.isPresent() || vehicleOptional.get().isDeleted()) {
            throw new EntityNotFoundException("Vehicle not found with id " + id);
        }

        Vehicle vehicle = vehicleOptional.get();
        vehicle.setDeleted(true);
        vehicleRepository.save(vehicle);
    }
}
