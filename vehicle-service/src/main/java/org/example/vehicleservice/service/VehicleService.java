package org.example.vehicleservice.service;
import jakarta.transaction.Transactional;
import org.example.vehicleservice.dto.VehicleDto;
import org.example.vehicleservice.model.Vehicle;
import org.example.vehicleservice.repository.VehicleRepo;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VehicleService {
    @Autowired
    private VehicleRepo vehicleRepo;
    @Autowired
    private ModelMapper modelMapper;

    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = modelMapper.map(vehicleDto, Vehicle.class);
        Vehicle vehicleSaved = vehicleRepo.save(vehicle);
        return modelMapper.map(vehicleSaved, VehicleDto.class);

    }
    public VehicleDto UpdateVehicle(VehicleDto userDto){
        Vehicle vehicle = modelMapper.map(userDto,Vehicle.class);
        Vehicle savedVehicle = vehicleRepo.save(vehicle);
        return modelMapper.map(savedVehicle,VehicleDto.class);
    }
    public List<VehicleDto> findAllVehicles() {
       List<Vehicle>vehicleList = vehicleRepo.findAll();
       return modelMapper.map(vehicleList, new TypeToken<List<VehicleDto>>() {}.getType());

    }
    public VehicleDto findVehicleById(Integer id){
        Vehicle vehicle = vehicleRepo.findVehicleById(id);
        return modelMapper.map(vehicle, VehicleDto.class);

    }
    public List<VehicleDto> findVehiclesByUserId(Integer userId) {
        List<Vehicle> vehicles = vehicleRepo.findByUserId(userId);
        return vehicles.stream()
                .map(vehicle -> modelMapper.map(vehicle, VehicleDto.class))
                .toList();
    }

    public String deleteVehicleById(Integer id){
        vehicleRepo.deleteById(id);
        return "vehicle deleted";
    }



}
