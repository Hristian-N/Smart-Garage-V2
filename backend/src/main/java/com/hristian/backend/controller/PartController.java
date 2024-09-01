package com.hristian.backend.controller;

import com.hristian.backend.dto.PartRequestDTO;
import com.hristian.backend.dto.PartResponseDTO;
import com.hristian.backend.exception.EntityNotFoundException;
import com.hristian.backend.service.PartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/part")
public class PartController {

    private final PartService partService;

    public PartController(PartService partService){
        this.partService = partService;
    }

    // Create
    @PostMapping()
    public PartResponseDTO create(@RequestBody PartRequestDTO partRequestDTO){
        return partService.create(partRequestDTO);
    }

    // Read
    @GetMapping()
    public List<PartResponseDTO> getAll() {
        return partService.getAll();
    }

    // TODO add filterBy Method

    @GetMapping("/{id}")
    public PartResponseDTO getById(@PathVariable long id){
        return partService.getById(id);
    }

    // Update
    @PutMapping("/{id}")
    public PartResponseDTO update(@PathVariable Long id, @RequestBody PartRequestDTO partRequestDTO) {
        return partService.update(id, partRequestDTO);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        partService.delete(id);
        return "Part deleted successfully.";
    }
}