package com.agrico.api.equipments.services.impl;

import com.agrico.api.equipments.dtos.EquipmentRequestDTO;
import com.agrico.api.equipments.models.Equipment;
import com.agrico.api.equipments.repositories.EquipmentRepository;
import com.agrico.api.equipments.services.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;

    @Override
    public Equipment createEquipment(EquipmentRequestDTO request) {
        Equipment equipment = Equipment.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .category(request.getCategory())
                .contract(request.getContract())
                .price(request.getPrice())
                .location(request.getLocation())
                .lng(request.getLng())
                .lat(request.getLat())
                .imageUrls(request.getImageUrls())
                .userId(request.getUserId())
                .status(request.getStatus())
                .build();
        return equipmentRepository.save(equipment);
    }

    @Override
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    @Override
    public Equipment getEquipmentById(UUID id) {
        return equipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<Equipment> getEquipmentByUserId(String userId) {
        return equipmentRepository.findByUserId(userId);
    }

    @Override
    public Equipment updateEquipment(UUID id, EquipmentRequestDTO request) {
        Equipment equipment = getEquipmentById(id);
        equipment.setTitle(request.getTitle());
        equipment.setDescription(request.getDescription());
        equipment.setCategory(request.getCategory());
        equipment.setContract(request.getContract());
        equipment.setPrice(request.getPrice());
        equipment.setLocation(request.getLocation());
        equipment.setLng(request.getLng());
        equipment.setLat(request.getLat());
        equipment.setImageUrls(request.getImageUrls());
        equipment.setStatus(request.getStatus());

        return equipmentRepository.save(equipment);
    }

    @Override
    public void deleteEquipment(UUID id) {
        equipmentRepository.deleteById(id);
    }
}