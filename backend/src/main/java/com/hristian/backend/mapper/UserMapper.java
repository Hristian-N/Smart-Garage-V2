package com.hristian.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.hristian.backend.dto.UserRequestDTO;
import com.hristian.backend.dto.UserResponseDTO;
import com.hristian.backend.model.User;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponseDTO userToUserResponseDTO(User user);

    User userRequestDTOToUser(UserRequestDTO userRequestDTO);

    List<UserResponseDTO> userToUserResponseDTO(List<User> users);
}
