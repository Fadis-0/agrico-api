package com.agrico.api.terrains.controllers;

import com.agrico.api.terrains.dtos.TerrainsRequestDTO;
import com.agrico.api.terrains.models.Terrains;
import com.agrico.api.terrains.services.TerrainsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/terrains")
@RequiredArgsConstructor
public class TerrainsController {

    private final TerrainsService terrainsService;

    @PostMapping
    public ResponseEntity<Terrains> createTerrains(@RequestBody TerrainsRequestDTO request) {
        return ResponseEntity.ok(terrainsService.createTerrains(request));
    }

    @GetMapping
    public ResponseEntity<List<Terrains>> getAllTerrains() {
        return ResponseEntity.ok(terrainsService.getAllTerrains());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Terrains> getTerrainsById(@PathVariable UUID id) {
        return ResponseEntity.ok(terrainsService.getTerrainsById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Terrains>> getTerrainsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(terrainsService.getTerrainsByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Terrains> updateTerrains(@PathVariable UUID id, @RequestBody TerrainsRequestDTO request) {
        return ResponseEntity.ok(terrainsService.updateTerrains(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTerrains(@PathVariable UUID id) {
        terrainsService.deleteTerrains(id);
        return ResponseEntity.noContent().build();
    }

}