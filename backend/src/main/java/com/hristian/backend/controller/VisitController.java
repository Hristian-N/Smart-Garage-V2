package com.hristian.backend.controller;

import com.hristian.backend.dto.VehicleRequestDTO;
import com.hristian.backend.dto.VisitRequestDTO;
import com.hristian.backend.dto.VisitResponseDTO;
import com.hristian.backend.service.VisitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visit")
public class VisitController {

    private final VisitService visitService;

    public VisitController(VisitService visitService){
        this.visitService = visitService;
    }

    // Create
    @PostMapping()
    public VisitResponseDTO create(@RequestBody VisitRequestDTO visitRequestDTO){
        return visitService.create(visitRequestDTO);
    }

    // Read
    @GetMapping()
    public List<VisitResponseDTO> getAll() {
        return visitService.getAll();
    }

    // TODO add filterBy Method

    @GetMapping("/{id}")
    public VisitResponseDTO getById(@PathVariable long id){
        return visitService.getById(id);
    }

    // Update
    @PutMapping("/{id}")
    public VisitResponseDTO update(@PathVariable Long id, @RequestBody VisitRequestDTO visitRequestDTO) {
        return visitService.update(id, visitRequestDTO);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        visitService.delete(id);
        return "Visit deleted successfully.";
    }
}
