package com.microservicios.booking_service.controller;

import com.microservicios.booking_service.dto.BookingDto;
import com.microservicios.booking_service.dto.BookingToSaveDto;
import com.microservicios.booking_service.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping()
    public ResponseEntity<List<BookingDto>> getBookings(){
        List<BookingDto> bookingsDto = bookingService.findAll();
        return ResponseEntity.ok().body(bookingsDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable("id") UUID id){
        try{
            BookingDto bookingFound = bookingService.findById(id);
            return ResponseEntity.ok().body(bookingFound);
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<BookingDto> createBooking(@RequestBody BookingToSaveDto bookingToSaveDto){
        BookingDto bookingSaved = bookingService.create(bookingToSaveDto);
        return ResponseEntity.ok().body(bookingSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable("id") UUID id){
        bookingService.deleteBooking(id);
        return ResponseEntity.ok().body("Booking deleted successfully");
    }

}
