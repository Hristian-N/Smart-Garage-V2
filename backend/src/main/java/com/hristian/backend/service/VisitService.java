package com.hristian.backend.service;

import com.hristian.backend.dto.VisitRequestDTO;
import com.hristian.backend.dto.VisitResponseDTO;
import com.hristian.backend.exception.EntityNotFoundException;
import com.hristian.backend.mapper.VisitMapper;
import com.hristian.backend.model.User;
import com.hristian.backend.model.Vehicle;
import com.hristian.backend.model.Visit;
import com.hristian.backend.repository.VisitRepository;
import com.hristian.backend.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VisitService {

    private final VisitRepository visitRepository;
    private final VehicleRepository vehicleRepository;
    private final VisitMapper visitMapper = VisitMapper.INSTANCE;

    @Autowired
    public VisitService(VisitRepository visitRepository, VehicleRepository vehicleRepository) {
        this.visitRepository = visitRepository;
        this.vehicleRepository = vehicleRepository;
    }

    // Create
    public VisitResponseDTO create(VisitRequestDTO visitRequestDTO) {
        // Load the Vehicle entity using the provided vehicleId
        Vehicle vehicle = vehicleRepository.findById(visitRequestDTO.getVehicleId())
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found with id " + visitRequestDTO.getVehicleId()));

        // Map the VisitRequestDTO to a Visit entity
        Visit visit = visitMapper.visitRequestDTOToVisit(visitRequestDTO);

        // Associate the Vehicle with the Visit
        visit.setVehicle(vehicle);

        // Save the Visit entity
        Visit savedVisit = visitRepository.save(visit);

        // Map the saved Visit entity to a response DTO and return it
        VisitResponseDTO result = visitMapper.visitToVisitResponseDTO(savedVisit);
        return result;
    }

    // Read
    public List<VisitResponseDTO> getAll() {

        List<Visit> visits = visitRepository.findAll()
                .stream()
                .filter(visit -> !visit.isDeleted())
                .collect(Collectors.toList());
        return visitMapper.visitToVisitResponseDTO(visits);
    }

    public VisitResponseDTO getById(Long id) {
        Optional<Visit> visitOptional = visitRepository.findById(id);

        if (!visitOptional.isPresent() || visitOptional.get().isDeleted()) {
            throw new EntityNotFoundException("Visit not found with id " + id);
        }

        Visit visit = visitOptional.get();
        return visitMapper.visitToVisitResponseDTO(visit);
    }

    // Update
    public VisitResponseDTO update(Long id, VisitRequestDTO visitRequestDTO) {
        Optional<Visit> visitOptional = visitRepository.findById(id);

        if (!visitOptional.isPresent() || visitOptional.get().isDeleted()) {
            throw new EntityNotFoundException("Visit not found with id " + id);
        }

        Visit visit = visitOptional.get();

        // Update code
        visit.setDate(visitRequestDTO.getDate());

        return visitMapper.visitToVisitResponseDTO(visitRepository.save(visit));
    }

    // Delete
    public void delete(Long id) {

        Optional<Visit> visitOptional = visitRepository.findById(id);

        if (!visitOptional.isPresent() || visitOptional.get().isDeleted()) {
            throw new EntityNotFoundException("Visit not found with id " + id);
        }

        Visit visit = visitOptional.get();
        visit.setDeleted(true);
        visitRepository.save(visit);
    }
}
