package com.autorenta.Booking.dto;

import com.autorenta.Booking.utils.StatusBooking;

import java.time.LocalDateTime;
import java.util.UUID;

public record BookingToSaveDto(
        UUID carId,
        UUID customerId,
        StatusBooking status,
        LocalDateTime startDate,
        LocalDateTime endDate

) {
}
