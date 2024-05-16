package com.autorenta.CarInventory.dto;

public record CarToSaveDto(
        String model,
        String make,
        Boolean available
) {
}
