package com.agrico.api.users.dtos;

import lombok.Data;
import java.util.UUID;

import java.util.List;

@Data
public class UsersRequestDTO {
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
    private String imageUrl;
    private String status;
    private List<String> transportationTypes;
    private List<String> operatorTypes;
}