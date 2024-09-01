package com.hristian.backend.mapper;

import com.hristian.backend.dto.VehicleRequestDTO;
import com.hristian.backend.dto.VehicleResponseDTO;
import com.hristian.backend.model.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VehicleMapper {

    VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);

    @Mapping(source = "user.id", target = "userId")
    VehicleResponseDTO vehicleToVehicleResponseDTO(Vehicle vehicle);

    @Mapping(target = "user", ignore = true)
    Vehicle vehicleRequestDTOToVehicle(VehicleRequestDTO vehicleRequestDTO);

    List<VehicleResponseDTO> vehicleToVehicleResponseDTO(List<Vehicle> vehicles);
}

