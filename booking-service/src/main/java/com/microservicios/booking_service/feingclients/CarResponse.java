package com.microservicios.booking_service.feingclients;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CarResponse {

    private UUID id;
    private String model;
    private String make;
    private Boolean available;

}
