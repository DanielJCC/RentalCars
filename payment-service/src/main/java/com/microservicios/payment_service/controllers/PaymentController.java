package com.microservicios.payment_service.controllers;

import com.microservicios.payment_service.dto.payment.PaymentDto;
import com.microservicios.payment_service.dto.payment.PaymentToSaveDto;
import com.microservicios.payment_service.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/payments")
public class PaymentController {
    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }

    @PostMapping()
    public ResponseEntity<PaymentDto> createPayment(@RequestBody PaymentToSaveDto paymentToSaveDto){
        PaymentDto paymentSaved = paymentService.create(paymentToSaveDto);
        return ResponseEntity.ok().body(paymentSaved);
    }

    @PutMapping("/processPayment/{id}")
    public ResponseEntity<PaymentDto> processPayment(@PathVariable("id") UUID id) {
        try {
            PaymentDto paymentProcessed = paymentService.processPayment(id);
            return ResponseEntity.ok().body(paymentProcessed);
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<PaymentDto>> getPayments(){
        List<PaymentDto> payments = paymentService.findAll();
        return ResponseEntity.ok().body(payments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDto> getPaymentById(@PathVariable("id") UUID id){
        try{
            PaymentDto paymentFound = paymentService.findById(id);
            return ResponseEntity.ok().body(paymentFound);
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
