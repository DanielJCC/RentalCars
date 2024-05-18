package com.microservicios.booking_service.repository;

import com.microservicios.booking_service.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> { }
