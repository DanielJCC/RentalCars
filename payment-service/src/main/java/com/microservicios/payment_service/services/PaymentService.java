package com.microservicios.payment_service.services;

import com.microservicios.payment_service.dto.payment.PaymentDto;
import com.microservicios.payment_service.dto.payment.PaymentToSaveDto;

import java.util.List;
import java.util.UUID;

public interface PaymentService {
    PaymentDto create(PaymentToSaveDto paymentToSaveDto);
    PaymentDto processPayment(UUID id);
    List<PaymentDto> findAll();
    PaymentDto findById(UUID id);
}
