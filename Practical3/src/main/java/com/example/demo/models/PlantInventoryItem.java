package com.example.demo.models;

import com.example.demo.models.enums.EquipmentCondition;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PlantInventoryItem {
    @Id
    @GeneratedValue
    Long id;

    String serialNumber;

    @Enumerated(EnumType.STRING)
    EquipmentCondition equipmentCondition;

    @ManyToOne
    PlantInventoryEntry plantInfo;

    public PlantInventoryItem(Long id, String serialNumber, EquipmentCondition equipmentCondition, PlantInventoryEntry plantInfo) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.equipmentCondition = equipmentCondition;
        this.plantInfo = plantInfo;
    }
}
