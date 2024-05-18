package com.microservicios.booking_service.service;

import com.microservicios.booking_service.dto.BookingDto;
import com.microservicios.booking_service.dto.BookingToSaveDto;
import com.microservicios.booking_service.entities.Booking;
import com.microservicios.booking_service.mappers.BookingMapper;
import com.microservicios.booking_service.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService{


    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    @Override
    public BookingDto create(BookingToSaveDto bookingToSaveDto) {
        Booking bookingToSave = bookingMapper.toSaveDtoToEntity(bookingToSaveDto);
        Booking bookingSaved = bookingRepository.save(bookingToSave);
        return bookingMapper.EntityToDto(bookingSaved);
    }

    @Override
    public List<BookingDto> findAll() {
        List<Booking> allBookings = bookingRepository.findAll();
        return allBookings.stream().parallel().map(bookingMapper::EntityToDto).toList();
    }

    @Override
    public BookingDto findById(UUID id) {
        Booking bookingFound = bookingRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Booking not found"));
        return bookingMapper.EntityToDto(bookingFound);
    }

    @Override
    public void deleteBooking(UUID bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
