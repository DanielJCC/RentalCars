package com.autorenta.Payment.dto.payment;

import com.autorenta.Payment.utilities.PaymentStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.UUID;

public record PaymentDto(
        UUID id,
        UUID bookingId,
        Long amount,
        PaymentStatus status,
        UUID transactionId
){ }
