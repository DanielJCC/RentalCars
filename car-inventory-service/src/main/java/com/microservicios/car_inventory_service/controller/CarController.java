package com.microservicios.car_inventory_service.controller;

import com.microservicios.car_inventory_service.dto.CarDto;
import com.microservicios.car_inventory_service.dto.CarToSaveDto;
import com.microservicios.car_inventory_service.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/cars")
public class CarController {
    private final CarService carService;
    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping()
    public ResponseEntity<List<CarDto>> getCars(){
        List<CarDto> carsDto = carService.findAll();
        return ResponseEntity.ok().body(carsDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable("id") UUID id){
        try{
            CarDto carFound = carService.findById(id);
            return ResponseEntity.ok().body(carFound);
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listAvailableCars")
    public ResponseEntity<List<CarDto>> getAvailableCars(){
        List<CarDto> carsFound = carService.listAvailableCars();
        return ResponseEntity.ok().body(carsFound);
    }

    @PostMapping()
    public ResponseEntity<CarDto> createCar(@RequestBody CarToSaveDto carToSaveDto){
        CarDto carSaved = carService.create(carToSaveDto);
        return ResponseEntity.ok().body(carSaved);
    }

    @PutMapping("/reserveCar/{id}")
    public ResponseEntity<CarDto> reserveCar(@PathVariable("id") UUID id) {
        try {
            CarDto carReserved = carService.reserveCar(id);
            return ResponseEntity.ok().body(carReserved);
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/returnCar/{id}")
    public ResponseEntity<CarDto> returnCar(@PathVariable("id") UUID id) {
        try {
            CarDto carReserved = carService.reserveCar(id);
            return ResponseEntity.ok().body(carReserved);
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
