package com.example.demo.models;

import com.example.demo.DemoApplication;
import com.example.demo.repositories.InventoryRepository;
import com.example.demo.repositories.PlantInventoryEntryRepository;
import com.example.demo.repositories.PlantInventoryItemRepository;
import com.example.demo.repositories.PlantReservationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@Sql(scripts = "plants-dataset.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class InventoryRepositoryTest {
    @Autowired
    PlantInventoryEntryRepository plantInventoryEntryRepository;
    @Autowired
    PlantInventoryItemRepository plantInventoryItemRepository;
    @Autowired
    PlantReservationRepository plantReservationRepository;
    @Autowired
    InventoryRepository inventoryRepository;

    @Test
    public void queryPlantCatalog() {
        assertThat(plantInventoryEntryRepository.count()).isEqualTo(14L);
    }

    @Test
    public void queryByName() {
        assertThat(plantInventoryEntryRepository.findByNameContaining("Mini").size()).isEqualTo(2);
    }

    @Test
    public void findAvailableTest() {
        PlantInventoryEntry entry = plantInventoryEntryRepository.findOne(1L);
        PlantInventoryItem item = plantInventoryItemRepository.findOneByPlantInfo(entry);

        assertThat(inventoryRepository.findAvailablePlants(LocalDate.of(2017, 2, 20), LocalDate.of(2017, 2, 25)))
                .doesNotContain(entry);

        PlantReservation plantReservation = new PlantReservation();
        plantReservation.setPlant(item);
        plantReservation.setSchedule(
                BusinessPeriod.of(LocalDate.of(2017, 2, 20), LocalDate.of(2017, 2, 25))
        );

        plantReservationRepository.save(plantReservation);

        assertThat(inventoryRepository.findAvailablePlants(LocalDate.of(2017, 2, 20), LocalDate.of(2017, 2, 25)))
                .contains(entry);
    }
}