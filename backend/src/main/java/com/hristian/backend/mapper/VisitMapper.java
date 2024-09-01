package com.hristian.backend.mapper;

import com.hristian.backend.dto.VehicleRequestDTO;
import com.hristian.backend.dto.VehicleResponseDTO;
import com.hristian.backend.dto.VisitRequestDTO;
import com.hristian.backend.dto.VisitResponseDTO;
import com.hristian.backend.model.Vehicle;
import com.hristian.backend.model.Visit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VisitMapper {

    VisitMapper INSTANCE = Mappers.getMapper(VisitMapper.class);

    VisitResponseDTO visitToVisitResponseDTO(Visit visit);

    Visit visitRequestDTOToVisit(VisitRequestDTO visitRequestDTO);

    List<VisitResponseDTO> visitToVisitResponseDTO(List<Visit> visits);
}
