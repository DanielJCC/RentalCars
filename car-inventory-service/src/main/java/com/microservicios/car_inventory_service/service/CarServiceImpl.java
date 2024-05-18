package com.microservicios.car_inventory_service.service;

import com.microservicios.car_inventory_service.dto.CarDto;
import com.microservicios.car_inventory_service.dto.CarToSaveDto;
import com.microservicios.car_inventory_service.entities.Car;
import com.microservicios.car_inventory_service.mappers.CarMapper;
import com.microservicios.car_inventory_service.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService {
    private final CarMapper carMapper;
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarMapper carMapper, CarRepository carRepository){
        this.carMapper = carMapper;
        this.carRepository = carRepository;
    }
    @Override
    public CarDto create(CarToSaveDto carToSaveDto) {
        Car carToSave = carMapper.toSaveDtoToEntity(carToSaveDto);
        Car carSaved = carRepository.save(carToSave);
        return carMapper.EntityToDto(carSaved);
    }

    @Override
    public List<CarDto> findAll() {
        List<Car> allCars = carRepository.findAll();
        return allCars.stream().parallel().map(carMapper::EntityToDto).toList();
    }

    @Override
    public CarDto findById(UUID id) {
        Car carFound = carRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Car not found"));
        return carMapper.EntityToDto(carFound);
    }

    @Override
    public List<CarDto> listAvailableCars() {
        List<Car> carsFound = carRepository.findByAvailable(true);
        return carsFound.stream().parallel().map(carMapper::EntityToDto).toList();
    }

    @Override
    public CarDto reserveCar(UUID carId) {
        Car carFound = carRepository.findById(carId)
                .orElseThrow(()->new RuntimeException("Car not found"));
        carFound.setAvailable(false);
        Car carUpdated = carRepository.save(carFound);
        return carMapper.EntityToDto(carUpdated);
    }

    @Override
    public CarDto returnCar(UUID carId) {
        Car carFound = carRepository.findById(carId)
                .orElseThrow(()->new RuntimeException("Car not found"));
        carFound.setAvailable(true);
        Car carUpdated = carRepository.save(carFound);
        return carMapper.EntityToDto(carUpdated);
    }
}
