package com.example.demo.models.dto;


import com.example.demo.models.enums.POStatus;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;


@Data
public class PurchaseOrderDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    POStatus status;

    BusinessPeriodDTO rentalPeriod;

    PlantInventoryEntryDTO plant;

    BigDecimal total;
}