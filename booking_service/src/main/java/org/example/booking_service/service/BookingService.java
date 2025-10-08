package org.example.booking_service.service;

import jakarta.transaction.Transactional;
import org.example.booking_service.dto.BookingDto;
import org.example.booking_service.model.Booking;
import org.example.booking_service.repository.BookingRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingService {
    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private ModelMapper modelMapper;

    public BookingDto createBooking(BookingDto bookingDto) {
        Booking booking = modelMapper.map(bookingDto, Booking.class);
        Booking savedBooking = bookingRepo.save(booking);
        return modelMapper.map(savedBooking, BookingDto.class);
    }


    public BookingDto updateBooking(BookingDto bookingDto) {
        Optional<Booking> existingBooking = bookingRepo.findById(bookingDto.getBookingId());
        if (existingBooking.isPresent()) {
            Booking booking = modelMapper.map(bookingDto, Booking.class);
            Booking savedBooking = bookingRepo.save(booking);
            return modelMapper.map(savedBooking, BookingDto.class);
        }
        return null;
    }

    public boolean deleteBooking(int id) {
        if (bookingRepo.existsById(id)) {
            bookingRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public BookingDto getBookingById(int id) {
        Optional<Booking> booking = bookingRepo.findById(id);
        return booking.map(value -> modelMapper.map(value, BookingDto.class)).orElse(null);
    }

    public List<BookingDto> getAllBookings() {
        List<Booking> bookings = bookingRepo.findAll();
        return modelMapper.map(bookings, new TypeToken<List<BookingDto>>(){}.getType());
    }

    //  Get all bookings by user ID
    public List<BookingDto> getBookingsByUserId(int userId) {
        List<Booking> bookings = bookingRepo.findByUserId(userId);
        return modelMapper.map(bookings, new TypeToken<List<BookingDto>>(){}.getType());
    }
}