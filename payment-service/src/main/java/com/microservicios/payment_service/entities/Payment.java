package com.microservicios.payment_service.entities;

import com.microservicios.payment_service.utilities.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID bookingId;
    private Long amount;
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    private UUID transactionId;
}
