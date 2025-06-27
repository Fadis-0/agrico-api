package com.agrico.api.equipments.services;

import com.agrico.api.equipments.dtos.EquipmentRequestDTO;
import com.agrico.api.equipments.models.Equipment;

import java.util.List;
import java.util.UUID;

public interface EquipmentService {
    Equipment createEquipment(EquipmentRequestDTO request);
    List<Equipment> getAllEquipment();
    Equipment getEquipmentById(UUID id);
    List<Equipment> getEquipmentByUserId(String userId);
    Equipment updateEquipment(UUID id, EquipmentRequestDTO request);
    void deleteEquipment(UUID id);
}