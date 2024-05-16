package com.autorenta.CarInventory.mappers;

import com.autorenta.CarInventory.dto.CarDto;
import com.autorenta.CarInventory.dto.CarToSaveDto;
import com.autorenta.CarInventory.entities.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {
    Car DtoToEntity(CarDto carDto);
    CarDto EntityToDto(Car car);
    @Mapping(target = "id", ignore = true)
    Car toSaveDtoToEntity(CarToSaveDto carToSaveDto);
}
