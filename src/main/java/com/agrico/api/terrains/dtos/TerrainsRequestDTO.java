package com.agrico.api.terrains.dtos;

import lombok.Data;
import java.util.UUID;

import java.util.List;

@Data
public class TerrainsRequestDTO {
    private String title;
    private String description;
    private String type;
    private List<String> specs;
    private List<String> docs;
    private Double size;
    private Double price;
    private String location;
    private String lng;
    private String lat;
    private String fromDate;
    private String toDate;
    private List<String> imageUrls;
    private String userId;
    private String status;
}