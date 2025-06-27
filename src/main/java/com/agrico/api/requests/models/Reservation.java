package com.agrico.api.requests.models;

import lombok.*;
import org.hibernate.Hibernate;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.UUID;
import java.util.List;

import java.time.LocalDateTime;

@Entity
@Table(name = "Requests")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String srcUserId;

    @Column(nullable = false)
    private String destUserId;

    private String status;
    
    // Type Related (To Have its own Table)
    private String type;
    
    // Equipments
    private UUID equipmentId;
    private String equipmentTitle;

    // Work
    private String workerFirstName;
    private String workerLastName;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;

    // Operations
    private String operateOn;
    private String capacity;

    // Transport
    private String fromLocation;
    private String toLocation;

    private LocalDateTime createdAt = LocalDateTime.now();

}