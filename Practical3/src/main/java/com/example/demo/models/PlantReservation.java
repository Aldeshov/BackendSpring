package com.example.demo.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class PlantReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Embedded
    BusinessPeriod schedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    PurchaseOrder rental;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PlantInventoryItem.class)
    PlantInventoryItem plant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    MaintenancePlan maintenancePlan;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PlantReservation that = (PlantReservation) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
