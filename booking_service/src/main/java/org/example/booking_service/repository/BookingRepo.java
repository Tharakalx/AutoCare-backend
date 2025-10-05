package org.example.booking_service.repository;

import org.example.booking_service.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Integer> {
    // New method: Get all bookings by user ID (Spring Data JPA auto-generates the query)
    List<Booking> findByUserId(int userId);


}
