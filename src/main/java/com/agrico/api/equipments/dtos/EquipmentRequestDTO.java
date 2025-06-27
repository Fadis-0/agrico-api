package com.agrico.api.equipments.dtos;

import lombok.Data;
import java.util.UUID;

import java.util.List;

@Data
public class EquipmentRequestDTO {
    private String title;
    private String description;
    private String category;
    private String contract;
    private Double price;
    private String location;
    private String lng;
    private String lat;
    private List<String> imageUrls;
    private String userId;
    private String status;
}