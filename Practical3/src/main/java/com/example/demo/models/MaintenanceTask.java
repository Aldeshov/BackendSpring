package com.example.demo.models;

import com.example.demo.models.enums.TypeOfWork;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Embeddable
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class MaintenanceTask {
    @Id
    @GeneratedValue
    Long id;

    String description;

    @Enumerated
    TypeOfWork typeOfWork;

    @Column(precision=8, scale=2)
    BigDecimal price;

    @Embedded
    BusinessPeriod rentalPeriod;

    @ManyToOne
    PlantReservation reservation;
}
