package com.internship.Platform.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internship.Platform.dto.UserDTO;
import com.internship.Platform.entity.User;
import com.internship.Platform.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        // Create a User object from the DTO
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());

        // Save the user in the database
        User savedUser = userService.saveUser(user);

        // Return the saved user as DTO
        UserDTO savedUserDTO = new UserDTO();
        savedUserDTO.setUsername(savedUser.getUsername());
        savedUserDTO.setEmail(savedUser.getEmail());
        savedUserDTO.setRole(savedUser.getRole());

        return ResponseEntity.ok(savedUserDTO);
    }
}