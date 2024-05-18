package com.microservicios.car_inventory_service.repository;

import com.microservicios.car_inventory_service.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    List<Car> findByAvailable(Boolean available);
}
