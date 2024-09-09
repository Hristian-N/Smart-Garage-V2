package com.hristian.backend.service;

import com.hristian.backend.dto.ServiceRequestDTO;
import com.hristian.backend.dto.ServiceResponseDTO;
import com.hristian.backend.exception.EntityNotFoundException;
import com.hristian.backend.mapper.ServiceMapper;
import com.hristian.backend.model.ServiceModel;
import com.hristian.backend.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceService {

    private final ServiceRepository serviceRepository;
    private final ServiceMapper serviceMapper = ServiceMapper.INSTANCE;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository){
        this.serviceRepository = serviceRepository;
    }


    // Create
    public ServiceResponseDTO create(ServiceRequestDTO serviceRequestDTO){

        ServiceModel service = serviceMapper.serviceRequestDTOToService(serviceRequestDTO);
        ServiceModel savedService = serviceRepository.save(service);
        return serviceMapper.serviceToServiceResponseDTO(savedService);
    }

    // Read
    public List<ServiceResponseDTO> getAll() {

        List<ServiceModel> services = serviceRepository.findAll()
                .stream()
                .filter(service -> !service.isDeleted())
                .collect(Collectors.toList());
        return serviceMapper.serviceToServiceResponseDTO(services);
    }

    public ServiceResponseDTO getById(Long id) {
        Optional<ServiceModel> serviceOptional = serviceRepository.findById(id);

        if (!serviceOptional.isPresent() || serviceOptional.get().isDeleted()) {
            throw new EntityNotFoundException("Part not found with id " + id);
        }

        ServiceModel service = serviceOptional.get();
        return serviceMapper.serviceToServiceResponseDTO(service);
    }

    // Update
    public ServiceResponseDTO update(Long id, ServiceRequestDTO serviceRequestDTO) {
        Optional<ServiceModel> serviceOptional = serviceRepository.findById(id);

        if (!serviceOptional.isPresent() || serviceOptional.get().isDeleted()) {
            throw new EntityNotFoundException("Service not found with id " + id);
        }

        ServiceModel service = serviceOptional.get();

        // Update code
        service.setName(serviceRequestDTO.getName());
        service.setPrice(serviceRequestDTO.getPrice());

        return serviceMapper.serviceToServiceResponseDTO(serviceRepository.save(service));
    }

    // Delete
    public void delete(Long id) {

        // Implemented through soft delete

        Optional<ServiceModel> serviceOptional = serviceRepository.findById(id);

        if (!serviceOptional.isPresent() || serviceOptional.get().isDeleted()) {
            throw new EntityNotFoundException("Service not found with id " + id);
        }

        ServiceModel service = serviceOptional.get();
        service.setDeleted(true);
        serviceRepository.save(service);
    }
}
