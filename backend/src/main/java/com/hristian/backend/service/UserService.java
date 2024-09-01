package com.hristian.backend.service;

import com.hristian.backend.dto.LogInDTO;
import com.hristian.backend.dto.UserRequestDTO;
import com.hristian.backend.dto.UserResponseDTO;
import com.hristian.backend.exception.EntityNotFoundException;
import com.hristian.backend.mapper.UserMapper;
import com.hristian.backend.model.User;
import com.hristian.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // Create
    public UserResponseDTO create(UserRequestDTO userRequestDTO){

        User user = userMapper.userRequestDTOToUser(userRequestDTO);

        try {
            User savedUser = userRepository.save(user);
            return userMapper.userToUserResponseDTO(savedUser);
        } catch (RuntimeException ex) {
            throw new RuntimeException("Email or Phone Number already exists.");
        }
    }

    // Read
    public List<UserResponseDTO> getAll() {

        List<User> users = userRepository.findAll()
                .stream()
                .filter(user -> !user.isDeleted())
                .collect(Collectors.toList());
        return userMapper.userToUserResponseDTO(users);
    }

    public UserResponseDTO getById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent() || userOptional.get().isDeleted()) {
            throw new EntityNotFoundException("User not found with id " + id);
        }

        User user = userOptional.get();
        return userMapper.userToUserResponseDTO(user);
    }

    // Update
    public UserResponseDTO update(Long id, UserRequestDTO userRequestDTO) {
        Optional<User> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent() || userOptional.get().isDeleted()) {
            throw new EntityNotFoundException("User not found with id " + id);
        }

        User user = userOptional.get();

        // Update code
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setEmail(userRequestDTO.getEmail());
        if (userRequestDTO.getPassword() != null && !userRequestDTO.getPassword().isEmpty()) {
            user.setPassword(userRequestDTO.getPassword()); // Assume setter hashes password
        }
        user.setPhoneNumber(userRequestDTO.getPhoneNumber());
        user.setAdmin(userRequestDTO.isAdmin());

        return userMapper.userToUserResponseDTO(userRepository.save(user));
    }

    // Delete
    public void delete(Long id) {

        // Implemented through soft delete

        Optional<User> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent() || userOptional.get().isDeleted()) {
            throw new EntityNotFoundException("User not found with id " + id);
        }

        User user = userOptional.get();
        user.setDeleted(true);
        userRepository.save(user);
    }

    // Other
    public UserResponseDTO logIn(LogInDTO logInDTO) {
        User user = userRepository.findByEmail(logInDTO.getEmail());

        if (user == null || user.isDeleted()) {
            throw new EntityNotFoundException("User not found or has been deleted.");
        }

        if (!user.isMatchingPassword(logInDTO.getPassword())) {
            throw new RuntimeException("Invalid credentials.");
        }

        return userMapper.userToUserResponseDTO(user);
    }

}
