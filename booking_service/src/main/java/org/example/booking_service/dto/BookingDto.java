package org.example.booking_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private int bookingId;
    private int userId;
    private int vehicleId;
    private LocalDate date;
    private LocalTime time;
    private String status;
    private String serviceType;
}
