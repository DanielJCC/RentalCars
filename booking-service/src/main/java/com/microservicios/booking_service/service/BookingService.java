package com.microservicios.booking_service.service;

import com.microservicios.booking_service.dto.BookingDto;
import com.microservicios.booking_service.dto.BookingToSaveDto;

import java.util.List;
import java.util.UUID;

public interface BookingService {
    BookingDto create(BookingToSaveDto bookingToSaveDto);
    List<BookingDto> findAll();
    BookingDto findById(UUID id);
    void deleteBooking(UUID bookingId);
}
