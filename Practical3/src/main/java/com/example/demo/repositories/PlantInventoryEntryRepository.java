package com.example.demo.repositories;

import com.example.demo.models.PlantInventoryEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantInventoryEntryRepository extends JpaRepository<PlantInventoryEntry, Long> {
    @Query("select p from PlantInventoryEntry p where p.id = ?1")
    PlantInventoryEntry findOne(Long id);

    @Query("select p from PlantInventoryEntry p where p.name like concat('%', ?1, '%')")
    List<PlantInventoryEntry> findByNameContaining(String name);
}