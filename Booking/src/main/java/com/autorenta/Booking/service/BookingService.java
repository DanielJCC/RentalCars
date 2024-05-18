package com.autorenta.Booking.service;

import com.autorenta.Booking.dto.BookingDto;
import com.autorenta.Booking.dto.BookingToSaveDto;

import java.util.List;
import java.util.UUID;

public interface BookingService {
    BookingDto create(BookingToSaveDto bookingToSaveDto);
    List<BookingDto> findAll();
    BookingDto findById(UUID id);
    void deleteBooking(UUID bookingId);
}
