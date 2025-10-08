package org.example.booking_service.controller;

import org.example.booking_service.dto.BookingDto;
import org.example.booking_service.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/v1")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/bookings")
    public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto , @RequestHeader("X-User-Id") String userId) {
        bookingDto.setUserId(Integer.parseInt(userId));
        BookingDto createdBooking = bookingService.createBooking(bookingDto);
        return ResponseEntity.ok(createdBooking);
    }



    @PutMapping("/bookings/{id}")
    public ResponseEntity<BookingDto> updateBooking(@PathVariable int id, @RequestBody BookingDto bookingDto) {
        bookingDto.setBookingId(id);
        BookingDto updatedBooking = bookingService.updateBooking(bookingDto);
        if (updatedBooking != null) {
            return ResponseEntity.ok(updatedBooking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/bookings/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable int id) {
        boolean deleted = bookingService.deleteBooking(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/bookings/{id}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable int id) {
        BookingDto booking = bookingService.getBookingById(id);
        if (booking != null) {
            return ResponseEntity.ok(booking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<BookingDto>> getAllBookings() {
        List<BookingDto> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }
}