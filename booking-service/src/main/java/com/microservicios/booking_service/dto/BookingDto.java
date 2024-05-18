package com.microservicios.booking_service.dto;

import com.microservicios.booking_service.utils.StatusBooking;
import java.time.LocalDateTime;
import java.util.UUID;

public record BookingDto(
        UUID id,
        UUID carId,
        UUID customerId,
        StatusBooking status,
        LocalDateTime startDate,
        LocalDateTime endDate
) {
}
