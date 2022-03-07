package com.example.demo.repositories;

import com.example.demo.models.PlantInventoryEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface InventoryRepository extends JpaRepository<PlantInventoryEntry, Long> {
    @Query(value = "select * from plant_inventory_entry where plant_inventory_entry.id in" +
            "(select plant_id from plant_reservation where plant_reservation.start_date >= ?1 and plant_reservation.end_date <= ?2)", nativeQuery = true)
    List<PlantInventoryEntry> findAvailablePlants(LocalDate startDate, LocalDate endDate);

    @Query(value = "select * from plant_inventory_entry where plant_inventory_entry.name like concat('%', ?1, '%') and plant_inventory_entry.id in" +
            "(select plant_id from plant_reservation where plant_reservation.start_date >= ?2 and plant_reservation.end_date <= ?3)", nativeQuery = true)
    List<PlantInventoryEntry> findAvailablePlantsByName(String name, LocalDate startDate, LocalDate endDate);
}