package com.agrico.api.requests.services;

import com.agrico.api.requests.dtos.ReservationRequestDTO;
import com.agrico.api.requests.models.Reservation;

import java.util.List;
import java.util.UUID;

public interface ReservationService {
    Reservation createReservation(ReservationRequestDTO request);
    List<Reservation> getAllReservation();
    Reservation getReservationById(UUID id);
    List<Reservation> getReservationBySrcUserId(String srcUserId);
    List<Reservation> getReservationByDestUserId(String destUserId);
    Reservation updateReservation(UUID id, ReservationRequestDTO request);
    void deleteReservation(UUID id);
}