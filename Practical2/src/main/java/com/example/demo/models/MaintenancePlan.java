package com.example.demo.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.type.ListType;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class MaintenancePlan {
    @Id
    @GeneratedValue
    Long id;

    Integer yearOfAction;

    @ManyToOne
    PlantInventoryItem plant;

    @OneToMany(cascade = {CascadeType.ALL})
    List<MaintenanceTask> tasks;
}
