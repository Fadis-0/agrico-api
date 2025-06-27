package com.agrico.api.requests.controllers;

import com.agrico.api.requests.dtos.ReservationRequestDTO;
import com.agrico.api.requests.models.Reservation;
import com.agrico.api.requests.services.ReservationService;
//import com.agrico.api.requests.rabbitmq.ReservationEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/requests")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    //private final ReservationEventPublisher publisher;

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationRequestDTO request) {
        return ResponseEntity.ok(reservationService.createReservation(request));
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservation() {
        return ResponseEntity.ok(reservationService.getAllReservation());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable UUID id) {
        return ResponseEntity.ok(reservationService.getReservationById(id));
    }

    @GetMapping("/srcuser/{srcUserId}")
    public ResponseEntity<List<Reservation>> getReservationBySrcUserId(@PathVariable String srcUserId) {
        return ResponseEntity.ok(reservationService.getReservationBySrcUserId(srcUserId));
    }

    @GetMapping("/destuser/{destUserId}")
    public ResponseEntity<List<Reservation>> getReservationByDestUserId(@PathVariable String destUserId) {
        return ResponseEntity.ok(reservationService.getReservationByDestUserId(destUserId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable UUID id, @RequestBody ReservationRequestDTO request) {
        return ResponseEntity.ok(reservationService.updateReservation(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable UUID id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }

}