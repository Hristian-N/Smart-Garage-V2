package com.hristian.backend.mapper;

import com.hristian.backend.dto.PartRequestDTO;
import com.hristian.backend.dto.PartResponseDTO;
import com.hristian.backend.model.Part;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PartMapper {

    PartMapper INSTANCE = Mappers.getMapper(PartMapper.class);

    PartResponseDTO partToPartResponseDTO(Part part);

    Part partRequestDTOToPart(PartRequestDTO partRequestDTO);

    List<PartResponseDTO> partToPartResponseDTO(List<Part> parts);
}

