package com.agrico.api.equipments.controllers;

import com.agrico.api.equipments.dtos.EquipmentRequestDTO;
import com.agrico.api.equipments.models.Equipment;
import com.agrico.api.equipments.services.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/equipments")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    @PostMapping
    public ResponseEntity<Equipment> createEquipment(@RequestBody EquipmentRequestDTO request) {
        return ResponseEntity.ok(equipmentService.createEquipment(request));
    }

    @GetMapping
    public ResponseEntity<List<Equipment>> getAllEquipment() {
        return ResponseEntity.ok(equipmentService.getAllEquipment());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipment> getEquipmentById(@PathVariable UUID id) {
        return ResponseEntity.ok(equipmentService.getEquipmentById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Equipment>> getEquipmentByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(equipmentService.getEquipmentByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipment> updateEquipment(@PathVariable UUID id, @RequestBody EquipmentRequestDTO request) {
        return ResponseEntity.ok(equipmentService.updateEquipment(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable UUID id) {
        equipmentService.deleteEquipment(id);
        return ResponseEntity.noContent().build();
    }


}