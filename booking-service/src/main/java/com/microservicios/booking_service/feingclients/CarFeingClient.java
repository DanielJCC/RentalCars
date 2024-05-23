package com.microservicios.booking_service.feingclients;


import com.microservicios.booking_service.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.UUID;

@FeignClient(name = "car-inventory-service", configuration = FeignConfig.class)
public interface CarFeingClient {

    @GetMapping("/api/v1/cars/{id}")
    public ResponseEntity<CarResponse> getCarById(@PathVariable("id") UUID id);

    @PutMapping("/api/v1/cars/reserveCar/{id}")
    public ResponseEntity<CarResponse> reserveCar(@PathVariable("id") UUID id);

    @PutMapping("/api/v1/cars/returnCar/{id}")
    public ResponseEntity<CarResponse> returnCar(@PathVariable("id") UUID id);

}
