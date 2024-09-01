package com.hristian.backend.controller;

import com.hristian.backend.dto.ServiceRequestDTO;
import com.hristian.backend.dto.ServiceResponseDTO;
import com.hristian.backend.service.ServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService){
        this.serviceService = serviceService;
    }


    // Create
    @PostMapping()
    public ServiceResponseDTO create(@RequestBody ServiceRequestDTO serviceRequestDTO){
        return serviceService.create(serviceRequestDTO);
    }

    // Read
    @GetMapping()
    public List<ServiceResponseDTO> getAll() {
        return serviceService.getAll();
    }

    // TODO add filterBy Method

    @GetMapping("/{id}")
    public ServiceResponseDTO getById(@PathVariable long id){
        return serviceService.getById(id);
    }

    // Update
    @PutMapping("/{id}")
    public ServiceResponseDTO update(@PathVariable Long id, @RequestBody ServiceRequestDTO serviceRequestDTO) {
        return serviceService.update(id, serviceRequestDTO);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        serviceService.delete(id);
        return "Service deleted successfully.";
    }
}
