package com.agrico.api.users.services.impl;

import com.agrico.api.users.dtos.UsersRequestDTO;
import com.agrico.api.users.models.Users;
import com.agrico.api.users.repositories.UsersRepository;
import com.agrico.api.users.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;


    @Override
    public Users createUsers(UsersRequestDTO request) {
        Optional<Users> existing = usersRepository.findByUserId(request.getUserId());

        Users users = existing.map(e -> {
            e.setFirstName(request.getFirstName());
            e.setLastName(request.getLastName());
            e.setEmail(request.getEmail());
            e.setPhone(request.getPhone());
            e.setAddress(request.getAddress());
            e.setType(request.getType());
            e.setPrice(request.getPrice());
            e.setPriceType(request.getPriceType());
            e.setLocation(request.getLocation());
            e.setTransportationTypes(request.getTransportationTypes());
            e.setOperatorTypes(request.getOperatorTypes());
            e.setLng(request.getLng());
            e.setLat(request.getLat());
            e.setImageUrl(request.getImageUrl());
            e.setStatus(request.getStatus());
            return e;
        }).orElseGet(() -> Users.builder()
            .userId(request.getUserId())
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .phone(request.getPhone())
            .address(request.getAddress())
            .type(request.getType())
            .price(request.getPrice())
            .priceType(request.getPriceType())
            .transportationTypes(request.getTransportationTypes())
            .operatorTypes(request.getOperatorTypes())
            .location(request.getLocation())
            .lng(request.getLng())
            .lat(request.getLat())
            .imageUrl(request.getImageUrl())
            .status(request.getStatus())
            .build());

        return usersRepository.save(users);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users getUsersById(UUID id) {
        return usersRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public Optional<Users> getUsersByUserId(String userId) {
        return usersRepository.findByUserId(userId);
    }

    @Override
    public List<Users> getUsersByType(String type) {
        return usersRepository.findByType(type);
    }

    @Override
    public Users updateUsers(UUID id, UsersRequestDTO request) {
        Users users = getUsersById(id);
        users.setFirstName(request.getFirstName());
        users.setLastName(request.getLastName());
        users.setEmail(request.getEmail());
        users.setPhone(request.getPhone());
        users.setAddress(request.getAddress());
        users.setType(request.getType());
        users.setLocation(request.getLocation());
        users.setLng(request.getLng());
        users.setLat(request.getLat());
        users.setImageUrl(request.getImageUrl());
        users.setStatus(request.getStatus());

        return usersRepository.save(users);
    }

    @Override
    public void deleteUsers(UUID id) {
        usersRepository.deleteById(id);
    }
}