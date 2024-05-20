package com.microservicios.booking_service.feingclients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.UUID;

@FeignClient(name = "car-inventory-service", url = "http://localhost:8081/api/v1/cars")
public interface CarFeingClient {

    @GetMapping("/{id}")
    public ResponseEntity<CarResponse> getCarById(@PathVariable("id") UUID id);

    @PutMapping("/reserveCar/{id}")
    public ResponseEntity<CarResponse> reserveCar(@PathVariable("id") UUID id);

    @PutMapping("/returnCar/{id}")
    public ResponseEntity<CarResponse> returnCar(@PathVariable("id") UUID id);

}
