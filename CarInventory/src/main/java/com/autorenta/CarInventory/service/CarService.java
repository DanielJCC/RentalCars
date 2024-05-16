package com.autorenta.CarInventory.service;

import com.autorenta.CarInventory.dto.CarDto;
import com.autorenta.CarInventory.dto.CarToSaveDto;

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
