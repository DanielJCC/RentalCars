package com.autorenta.CarInventory.dto;

import java.util.UUID;

public record CarDto(
        UUID id,
        String model,
        String make,
        Boolean available
) {
}
