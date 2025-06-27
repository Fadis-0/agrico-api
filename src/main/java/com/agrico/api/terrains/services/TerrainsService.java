package com.agrico.api.terrains.services;

import com.agrico.api.terrains.dtos.TerrainsRequestDTO;
import com.agrico.api.terrains.models.Terrains;

import java.util.List;
import java.util.UUID;

public interface TerrainsService {
    Terrains createTerrains(TerrainsRequestDTO request);
    List<Terrains> getAllTerrains();
    Terrains getTerrainsById(UUID id);
    List<Terrains> getTerrainsByUserId(String userId);
    Terrains updateTerrains(UUID id, TerrainsRequestDTO request);
    void deleteTerrains(UUID id);
}