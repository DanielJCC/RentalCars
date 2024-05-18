package com.autorenta.Payment.services;

import com.autorenta.Payment.dto.payment.PaymentDto;
import com.autorenta.Payment.dto.payment.PaymentToSaveDto;

import java.util.List;
import java.util.UUID;

public interface PaymentService {
    PaymentDto create(PaymentToSaveDto paymentToSaveDto);
    PaymentDto processPayment(UUID id);
    List<PaymentDto> findAll();
    PaymentDto findById(UUID id);
}
