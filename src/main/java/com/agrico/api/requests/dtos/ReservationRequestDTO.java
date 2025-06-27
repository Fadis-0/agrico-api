package com.agrico.api.requests.dtos;

import lombok.Data;
import java.util.UUID;

import java.util.List;

import java.time.LocalDateTime;

@Data
public class ReservationRequestDTO {
    private String srcUserId;
    private String destUserId;
    private String status;
    private String type;
    
    // Equipments & work
    private UUID equipmentId;
    private String equipmentTitle;
    private String workerFirstName;
    private String workerLastName;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;

    private String operateOn;
    private String capacity;

    // Transport
    private String fromLocation;
    private String toLocation;

    private LocalDateTime createdAt;

}