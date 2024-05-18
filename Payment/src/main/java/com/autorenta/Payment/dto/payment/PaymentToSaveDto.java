package com.autorenta.Payment.dto.payment;

import com.autorenta.Payment.utilities.PaymentStatus;

import java.util.UUID;

public record PaymentToSaveDto(
        UUID bookingId,
        Long amount,
        PaymentStatus status,
        UUID transactionId
) {
}
