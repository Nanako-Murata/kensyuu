package com.example.tonight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tonight.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
