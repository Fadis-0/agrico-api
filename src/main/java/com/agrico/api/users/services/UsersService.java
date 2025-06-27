package com.agrico.api.users.services;

import com.agrico.api.users.dtos.UsersRequestDTO;
import com.agrico.api.users.models.Users;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsersService {
    Users createUsers(UsersRequestDTO request);
    List<Users> getAllUsers();
    Users getUsersById(UUID id);
    Optional<Users> getUsersByUserId(String userId);
    List<Users> getUsersByType(String type);
    Users updateUsers(UUID id, UsersRequestDTO request);
    void deleteUsers(UUID id);
}