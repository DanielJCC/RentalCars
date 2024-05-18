package com.autorenta.Payment.services;

import com.autorenta.Payment.dto.payment.PaymentDto;
import com.autorenta.Payment.dto.payment.PaymentToSaveDto;
import com.autorenta.Payment.entities.Payment;
import com.autorenta.Payment.mappers.PaymentMapper;
import com.autorenta.Payment.repositories.PaymentRepository;
import com.autorenta.Payment.utilities.PaymentStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService{

    private final PaymentMapper paymentMapper;

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentMapper paymentMapper, PaymentRepository paymentRepository){
        this.paymentMapper=paymentMapper;
        this.paymentRepository=paymentRepository;
    }

    @Override
    public PaymentDto create(PaymentToSaveDto paymentToSaveDto) {
        Payment paymentSaved = paymentRepository.save(paymentMapper.toSaveDtoToEntity(paymentToSaveDto));
        return paymentMapper.EntityToDto(paymentSaved);
    }

    @Override
    public PaymentDto processPayment(UUID id) {
        Optional<Payment> paymentFound = paymentRepository.findById(id);
        paymentFound.get().setStatus(PaymentStatus.PAGADO);
        return paymentMapper.EntityToDto(paymentRepository.save(paymentFound.get()));
    }

    @Override
    public List<PaymentDto> findAll() {
        List<Payment> allPayments = paymentRepository.findAll();
        return allPayments.stream().parallel().map(paymentMapper::EntityToDto).toList();
    }

    @Override
    public PaymentDto findById(UUID id) {
        Optional<Payment> paymentFound = paymentRepository.findById(id);
        return paymentMapper.EntityToDto(paymentFound.get());
    }
}
