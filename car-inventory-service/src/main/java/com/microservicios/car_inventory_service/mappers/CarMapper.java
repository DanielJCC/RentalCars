package com.microservicios.car_inventory_service.mappers;

import com.microservicios.car_inventory_service.dto.CarDto;
import com.microservicios.car_inventory_service.dto.CarToSaveDto;
import com.microservicios.car_inventory_service.entities.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {
    Car DtoToEntity(CarDto carDto);
    CarDto EntityToDto(Car car);
    @Mapping(target = "id", ignore = true)
    Car toSaveDtoToEntity(CarToSaveDto carToSaveDto);
}
