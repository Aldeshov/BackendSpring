package com.example.demo.repositories;

import com.example.demo.models.PlantInventoryEntry;
import com.example.demo.models.PlantInventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantInventoryItemRepository extends JpaRepository<PlantInventoryItem, Long> {
    @Query("SELECT p FROM PlantInventoryItem p WHERE p.plantInfo = ?1")
    PlantInventoryItem findOneByPlantInfo(PlantInventoryEntry plant);
}
