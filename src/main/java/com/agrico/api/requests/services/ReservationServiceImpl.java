package com.agrico.api.requests.services.impl;

import com.agrico.api.requests.dtos.ReservationRequestDTO;
import com.agrico.api.requests.models.Reservation;
import com.agrico.api.requests.repositories.ReservationRepository;
import com.agrico.api.requests.services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public Reservation createReservation(ReservationRequestDTO request) {
        Reservation reservation = Reservation.builder()
                .srcUserId(request.getSrcUserId())
                .destUserId(request.getDestUserId())
                .status(request.getStatus())
                .type(request.getType())
                .equipmentId(request.getEquipmentId())
                .equipmentTitle(request.getEquipmentTitle())
                .workerFirstName(request.getWorkerFirstName())
                .workerLastName(request.getWorkerLastName())
                .operateOn(request.getOperateOn())
                .capacity(request.getCapacity())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .location(request.getLocation())
                .fromLocation(request.getFromLocation())
                .toLocation(request.getToLocation())
                .createdAt(request.getCreatedAt())
                .build();
        return reservationRepository.save(reservation);
    }
 
    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(UUID id) {
        return reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<Reservation> getReservationBySrcUserId(String srcUserId) {
        return reservationRepository.findBySrcUserId(srcUserId);
    }

    @Override
    public List<Reservation> getReservationByDestUserId(String destUserId) {
        return reservationRepository.findByDestUserId(destUserId);
    }

    @Override
    public Reservation updateReservation(UUID id, ReservationRequestDTO request) {
        Reservation reservation = getReservationById(id);

        reservation.setStatus(request.getStatus());

        reservation.setSrcUserId(request.getSrcUserId());
        reservation.setDestUserId(request.getDestUserId());
        reservation.setType(request.getType());
        reservation.setStartDate(request.getStartDate());
        reservation.setEndDate(request.getEndDate());
        reservation.setEquipmentTitle(request.getEquipmentTitle());
        reservation.setWorkerFirstName(request.getWorkerFirstName());
        reservation.setWorkerLastName(request.getWorkerLastName());
        reservation.setOperateOn(request.getOperateOn());
        reservation.setCapacity(request.getCapacity());
        reservation.setLocation(request.getLocation());
        reservation.setFromLocation(request.getFromLocation());
        reservation.setToLocation(request.getToLocation());
        reservation.setCreatedAt(request.getCreatedAt());

        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(UUID id) {
        reservationRepository.deleteById(id);
    }
}