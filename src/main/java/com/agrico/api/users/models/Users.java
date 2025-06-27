package com.agrico.api.users.models;

import lombok.*;
import org.hibernate.Hibernate;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.UUID;
import java.util.List;

@Entity
@Table(name = "Users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String userId;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String type;
    private String price;
    private String priceType;
    private String location;
    private String lng;
    private String lat;

    @ElementCollection
    private List<String> transportationTypes;

    @ElementCollection
    private List<String> operatorTypes;


    private String imageUrl;

    private String status;
}