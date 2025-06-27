package com.agrico.api.users.controllers;

import com.agrico.api.users.dtos.UsersRequestDTO;
import com.agrico.api.users.models.Users;
import com.agrico.api.users.services.UsersService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @PostMapping
    public ResponseEntity<Users> createUsers(@RequestBody UsersRequestDTO request) {
        return ResponseEntity.ok(usersService.createUsers(request));
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUsersById(@PathVariable UUID id) {
        return ResponseEntity.ok(usersService.getUsersById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Optional<Users>> getUsersByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(usersService.getUsersByUserId(userId));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Users>> getUsersByType(@PathVariable String type) {
        return ResponseEntity.ok(usersService.getUsersByType(type));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUsers(@PathVariable UUID id, @RequestBody UsersRequestDTO request) {
        return ResponseEntity.ok(usersService.updateUsers(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable UUID id) {
        usersService.deleteUsers(id);
        return ResponseEntity.noContent().build();
    }



}