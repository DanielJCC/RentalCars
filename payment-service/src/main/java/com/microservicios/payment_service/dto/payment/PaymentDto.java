package com.microservicios.payment_service.dto.payment;

import com.microservicios.payment_service.utilities.PaymentStatus;

import java.util.UUID;

public record PaymentDto(
        UUID id,
        UUID bookingId,
        Long amount,
        PaymentStatus status,
        UUID transactionId
){ }
