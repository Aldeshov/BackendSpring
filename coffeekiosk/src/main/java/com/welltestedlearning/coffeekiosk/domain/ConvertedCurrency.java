package com.welltestedlearning.coffeekiosk.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConvertedCurrency {
    private String currency;
    private BigDecimal converted;
}
