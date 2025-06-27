package com.agrico.api.terrains.services.impl;

import com.agrico.api.terrains.dtos.TerrainsRequestDTO;
import com.agrico.api.terrains.models.Terrains;
import com.agrico.api.terrains.repositories.TerrainsRepository;
import com.agrico.api.terrains.services.TerrainsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TerrainsServiceImpl implements TerrainsService {

    private final TerrainsRepository terrainsRepository;

    @Override
    public Terrains createTerrains(TerrainsRequestDTO request) {
        Terrains terrains = Terrains.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .type(request.getType())
                .specs(request.getSpecs())
                .docs(request.getDocs())
                .size(request.getSize())
                .price(request.getPrice())
                .location(request.getLocation())
                .lng(request.getLng())
                .lat(request.getLat())
                .fromDate(request.getFromDate())
                .toDate(request.getToDate())
                .imageUrls(request.getImageUrls())
                .userId(request.getUserId())
                .status(request.getStatus())
                .build();
        return terrainsRepository.save(terrains);
    }

    @Override
    public List<Terrains> getAllTerrains() {
        return terrainsRepository.findAll();
    }

    @Override
    public Terrains getTerrainsById(UUID id) {
        return terrainsRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<Terrains> getTerrainsByUserId(String userId) {
        return terrainsRepository.findByUserId(userId);
    }

    @Override
    public Terrains updateTerrains(UUID id, TerrainsRequestDTO request) {
        Terrains terrains = getTerrainsById(id);
        terrains.setTitle(request.getTitle());
        terrains.setDescription(request.getDescription());
        terrains.setType(request.getType());
        terrains.setSpecs(request.getSpecs());
        terrains.setDocs(request.getDocs());
        terrains.setSize(request.getSize());
        terrains.setPrice(request.getPrice());
        terrains.setLocation(request.getLocation());
        terrains.setLng(request.getLng());
        terrains.setLat(request.getLat());
        terrains.setFromDate(request.getFromDate());
        terrains.setToDate(request.getToDate());
        terrains.setImageUrls(request.getImageUrls());
        terrains.setStatus(request.getStatus());

        return terrainsRepository.save(terrains);
    }

    @Override
    public void deleteTerrains(UUID id) {
        terrainsRepository.deleteById(id);
    }
}