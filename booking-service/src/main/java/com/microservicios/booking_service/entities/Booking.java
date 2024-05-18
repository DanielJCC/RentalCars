package com.microservicios.booking_service.entities;

import com.microservicios.booking_service.utils.StatusBooking;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private UUID carId;

    @Column
    private UUID customerId;

    @Column
    @Enumerated(EnumType.STRING)
    private StatusBooking status;

    @Column
    private LocalDateTime startDate;

    @Column
    private LocalDateTime endDate;

}
