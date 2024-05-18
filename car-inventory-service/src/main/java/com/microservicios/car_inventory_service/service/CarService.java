package com.microservicios.car_inventory_service.service;


import com.microservicios.car_inventory_service.dto.CarDto;
import com.microservicios.car_inventory_service.dto.CarToSaveDto;

import java.util.List;
import java.util.UUID;

public interface CarService {
    CarDto create(CarToSaveDto carToSaveDto);
    List<CarDto> findAll();
    CarDto findById(UUID id);
    List<CarDto> listAvailableCars();
    CarDto reserveCar(UUID carId);
    CarDto returnCar(UUID carId);
}
