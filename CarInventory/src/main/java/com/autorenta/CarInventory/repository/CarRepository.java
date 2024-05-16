package com.autorenta.CarInventory.repository;

import com.autorenta.CarInventory.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    List<Car> findByAvailable(Boolean available);
}
