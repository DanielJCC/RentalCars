package com.microservicios.car_inventory_service.dto;

public record CarToSaveDto(
        String model,
        String make,
        Boolean available
) {
}
