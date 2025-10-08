package org.example.vehicleservice.repository;
import org.example.vehicleservice.model.Vehicle;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepo  extends JpaRepository<Vehicle,Integer> {
    // ✅ Find a single vehicle by its primary key (ID)
    @Query(value = "SELECT * FROM vehicle WHERE id = ?1", nativeQuery = true)
    Vehicle findVehicleById(int id);

    // ✅ Find all vehicles belonging to a given user
    @Query(value = "SELECT * FROM vehicle WHERE user_id = ?1", nativeQuery = true)
    List<Vehicle> findByUserId(int userId);



}
