package com.hristian.backend.mapper;

import com.hristian.backend.dto.ServiceRequestDTO;
import com.hristian.backend.dto.ServiceResponseDTO;
import com.hristian.backend.model.ServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ServiceMapper {
    ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

    ServiceResponseDTO serviceToServiceResponseDTO(ServiceModel service);

    ServiceModel serviceRequestDTOToService(ServiceRequestDTO serviceRequestDTO);

    List<ServiceResponseDTO> serviceToServiceResponseDTO(List<ServiceModel> services);
}

