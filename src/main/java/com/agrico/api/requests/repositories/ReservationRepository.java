package com.agrico.api.requests.repositories;

import com.agrico.api.requests.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
    List<Reservation> findBySrcUserId(String srcUserId);
    List<Reservation> findByDestUserId(String destUserId);
}