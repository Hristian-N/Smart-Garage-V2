package com.hristian.backend.controller;

import com.hristian.backend.dto.VehicleRequestDTO;
import com.hristian.backend.dto.VehicleResponseDTO;
import com.hristian.backend.exception.DuplicateEntryException;
import com.hristian.backend.exception.EntityNotFoundException;
import com.hristian.backend.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    // Create
    @PostMapping()
    public VehicleResponseDTO create(@RequestBody VehicleRequestDTO vehicleRequestDTO){
        return vehicleService.create(vehicleRequestDTO);
    }

    // Read
    @GetMapping()
    public List<VehicleResponseDTO> getAll() {
        return vehicleService.getAll();
    }

    // TODO add filterBy Method

    @GetMapping("/{id}")
    public VehicleResponseDTO getById(@PathVariable long id){
        return vehicleService.getById(id);
    }

    // Update
    @PutMapping("/{id}")
    public VehicleResponseDTO update(@PathVariable Long id, @RequestBody VehicleRequestDTO vehicleRequestDTO) {
        return vehicleService.update(id, vehicleRequestDTO);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        vehicleService.delete(id);
        return "Vehicle deleted successfully.";
    }

    // exceptions
    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<String> handleDuplicateEntryException(DuplicateEntryException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}
