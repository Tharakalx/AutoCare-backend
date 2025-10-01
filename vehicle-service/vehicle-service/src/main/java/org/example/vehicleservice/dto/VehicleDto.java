package org.example.vehicleservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {
    private int id;
    private int userId;
    private String model;
    private int mileage;
    private int year;
    private String brand;
    private String licencePlate;
    private String type;

}
