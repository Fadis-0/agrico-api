package com.agrico.api.equipments.models;

import lombok.*;
import org.hibernate.Hibernate;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.UUID;
import java.util.List;

@Entity
@Table(name = "Equipments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;
    private String description;
    private String category;
    private String contract;
    private Double price;
    private String location;
    private String lng;
    private String lat;

    @ElementCollection
    private List<String> imageUrls;

    @Column(nullable = false)
    private String userId;

    private String status;
}