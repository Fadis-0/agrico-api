package com.agrico.api.equipments.repositories;

import com.agrico.api.equipments.models.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EquipmentRepository extends JpaRepository<Equipment, UUID> {
    List<Equipment> findByUserId(String userId);
}