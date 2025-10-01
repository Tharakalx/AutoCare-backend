package org.example.vehicleservice.controllers;
import org.example.vehicleservice.dto.VehicleDto;
import org.example.vehicleservice.model.Vehicle;
import org.example.vehicleservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;
    @PostMapping("/addvehicle")
    public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleDto vehicleDto) {
        VehicleDto vehicle  = vehicleService.createVehicle(vehicleDto);
        return ResponseEntity.ok(vehicle);
    }
    @PutMapping("vehicleby")
    public ResponseEntity<VehicleDto> updateVehicle(@RequestBody VehicleDto vehicleDto) {
        VehicleDto updatedVehicle = vehicleService.UpdateVehicle(vehicleDto);
        return ResponseEntity.ok(updatedVehicle);
    }
    @GetMapping("vehicle")
    public ResponseEntity<List<VehicleDto>> getAllVehicles(@RequestHeader("X-User-Id") String userId ) {

        return ResponseEntity.ok(vehicleService.findAllVehicles());
    }
//    @GetMapping("/vehicle")
//    public ResponseEntity<VehicleDto> getVehicleById(@RequestParam Integer id) {
//        return ResponseEntity.ok(vehicleService.findVehicleById(id));
//    }
    @DeleteMapping("vehicle")
    public ResponseEntity<String> deleteVehicleById(@RequestParam Integer id) {
        return ResponseEntity.ok(vehicleService.deleteVehicleById(id));
    }
    @GetMapping("/getvehicles")
    public ResponseEntity<VehicleDto> getVehicles(@RequestHeader("X-User-Id") Integer userId) {
        System.out.println("UserId from gateway: " + userId);
        return ResponseEntity.ok(vehicleService.findVehicleByUserId(userId));
    }




}
