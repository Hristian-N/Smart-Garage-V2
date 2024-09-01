package com.hristian.backend.service;

import com.hristian.backend.dto.PartRequestDTO;
import com.hristian.backend.dto.PartResponseDTO;
import com.hristian.backend.exception.EntityNotFoundException;
import com.hristian.backend.mapper.PartMapper;
import com.hristian.backend.model.Part;
import com.hristian.backend.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartService {

    private final PartRepository partRepository;
    private final PartMapper partMapper = PartMapper.INSTANCE;

    @Autowired
    public PartService(PartRepository partRepository){
        this.partRepository = partRepository;
    }


    // Create
    public PartResponseDTO create(PartRequestDTO partRequestDTO){

        Part part = partMapper.partRequestDTOToPart(partRequestDTO);
        Part savedPart = partRepository.save(part);
        return partMapper.partToPartResponseDTO(savedPart);
    }

    // Read
    public List<PartResponseDTO> getAll() {

        List<Part> parts = partRepository.findAll()
                .stream()
                .filter(part -> !part.isDeleted())
                .collect(Collectors.toList());
        return partMapper.partToPartResponseDTO(parts);
    }

    public PartResponseDTO getById(Long id) {
        Optional<Part> partOptional = partRepository.findById(id);

        if (!partOptional.isPresent() || partOptional.get().isDeleted()) {
            throw new EntityNotFoundException("Part not found with id " + id);
        }

        Part part = partOptional.get();
        return partMapper.partToPartResponseDTO(part);
    }

    // Update
    public PartResponseDTO update(Long id, PartRequestDTO partRequestDTO) {
        Optional<Part> partOptional = partRepository.findById(id);

        if (!partOptional.isPresent() || partOptional.get().isDeleted()) {
            throw new EntityNotFoundException("Part not found with id " + id);
        }

        Part part = partOptional.get();

        // Update code
        part.setName(partRequestDTO.getName());
        part.setUnitPrice(partRequestDTO.getUnitPrice());

        return partMapper.partToPartResponseDTO(partRepository.save(part));
    }

    // Delete
    public void delete(Long id) {

        // Implemented through soft delete

        Optional<Part> partOptional = partRepository.findById(id);

        if (!partOptional.isPresent() || partOptional.get().isDeleted()) {
            throw new EntityNotFoundException("Part not found with id " + id);
        }

        Part part = partOptional.get();
        part.setDeleted(true);
        partRepository.save(part);
    }
}
