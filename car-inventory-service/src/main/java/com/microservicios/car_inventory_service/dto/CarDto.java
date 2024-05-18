package com.microservicios.car_inventory_service.dto;

import java.util.UUID;

public record CarDto(
        UUID id,
        String model,
        String make,
        Boolean available
) {
}
