package com.microservicios.booking_service.mappers;

import com.microservicios.booking_service.dto.BookingDto;
import com.microservicios.booking_service.dto.BookingToSaveDto;
import com.microservicios.booking_service.entities.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    Booking DtoToEntity(BookingDto bookingDto);
    BookingDto EntityToDto(Booking booking);
    @Mapping(target = "id", ignore = true)
    Booking toSaveDtoToEntity(BookingToSaveDto bookingToSaveDto);
}
