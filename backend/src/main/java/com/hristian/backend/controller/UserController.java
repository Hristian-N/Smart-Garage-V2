package com.hristian.backend.controller;

import com.hristian.backend.dto.LogInDTO;
import com.hristian.backend.dto.UserRequestDTO;
import com.hristian.backend.dto.UserResponseDTO;
import com.hristian.backend.exception.EntityNotFoundException;
import com.hristian.backend.model.User;
import com.hristian.backend.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    // Create
    @PostMapping()
    public UserResponseDTO create(@RequestBody UserRequestDTO userRequestDTO){
        return userService.create(userRequestDTO);
    }

    // Read
    @GetMapping()
    public List<UserResponseDTO> getAll() {
        return userService.getAll();
    }

    // TODO add filterBy Method

    @GetMapping("/{id}")
    public UserResponseDTO getById(@PathVariable long id){
        return userService.getById(id);
    }

    // Update
    @PutMapping("/{id}")
    public UserResponseDTO update(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
        return userService.update(id, userRequestDTO);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "User deleted successfully.";
    }

    // exceptions
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {

        if (ex.getMessage().contains("Email or Phone Number already exists.")) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("An unexpected error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Other
    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> logIn(@RequestBody LogInDTO logInDTO) {
        try {
            UserResponseDTO userResponseDTO = userService.logIn(logInDTO);
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            userResponseDTO.getEmail(),
                            logInDTO.getPassword()
                    );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            return ResponseEntity.ok(userResponseDTO);
        } catch (RuntimeException ex) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }
}
