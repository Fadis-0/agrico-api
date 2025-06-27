package com.agrico.api.terrains.models;

import lombok.*;
import org.hibernate.Hibernate;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.UUID;
import java.util.List;

@Entity
@Table(name = "Terrains")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Terrains {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;
    private String description;
    private String type;
    
    private Double size;
    private Double price;
    private String location;
    private String lng;
    private String lat;
    
    private String fromDate;
    private String toDate;

    @ElementCollection
    private List<String> imageUrls;

    @ElementCollection
    private List<String> specs;

    @ElementCollection
    private List<String> docs;

    @Column(nullable = false)
    private String userId;

    private String status;
}