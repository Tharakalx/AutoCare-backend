package org.example.vehicleservice.repository;
import org.example.vehicleservice.model.Vehicle;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleRepo  extends JpaRepository<Vehicle,Integer> {
@Query(value= " select * from vehicle where id = ?1 ", nativeQuery = true)
    public Vehicle findVehicleById(int userId);
    @Query(value= " select * from vehicle where userId = ?1 ", nativeQuery = true)
    public Vehicle findVehicleByUserId(int id);



}
