package com.agrico.api.users.repositories;

import com.agrico.api.users.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, UUID> {
    Optional<Users> findByUserId(String userId);
    List<Users> findByType(String type);
}