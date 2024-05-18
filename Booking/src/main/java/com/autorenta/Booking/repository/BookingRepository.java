package com.autorenta.Booking.repository;

import com.autorenta.Booking.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> { }
