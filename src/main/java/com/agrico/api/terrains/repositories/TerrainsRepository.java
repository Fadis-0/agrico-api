package com.agrico.api.terrains.repositories;

import com.agrico.api.terrains.models.Terrains;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TerrainsRepository extends JpaRepository<Terrains, UUID> {
    List<Terrains> findByUserId(String userId);
}