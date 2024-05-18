package com.autorenta.Booking.mappers;

import com.autorenta.Booking.dto.BookingDto;
import com.autorenta.Booking.dto.BookingToSaveDto;
import com.autorenta.Booking.entities.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    Booking DtoToEntity(BookingDto bookingDto);
    BookingDto EntityToDto(Booking booking);
    @Mapping(target = "id", ignore = true)
    Booking toSaveDtoToEntity(BookingToSaveDto bookingToSaveDto);
}
