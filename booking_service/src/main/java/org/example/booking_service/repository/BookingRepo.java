package org.example.booking_service.repository;

import org.example.booking_service.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Integer> {


}
