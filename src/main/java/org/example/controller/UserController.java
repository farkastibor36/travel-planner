package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserCreateDto;
import org.example.dto.UserDto;
import org.example.model.User;
import org.example.service.UserCRUDServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {
    private final UserCRUDServiceImpl userCRUDService;

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody UserCreateDto userCreateDto) {
        return ResponseEntity.ok(userCRUDService.createUser(userCreateDto));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userCRUDService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userCRUDService.getUserById(id));
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userCRUDService.deleteUser(id);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody UserCreateDto userCreateDto) {
        return ResponseEntity.ok(userCRUDService.updateUser(id, userCreateDto));
    }
}