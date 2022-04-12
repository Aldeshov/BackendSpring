package com.welltestedlearning.coffeekiosk.adapter.in.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CoffeeOrderRequest {
    String customerName;
    String size;
    String kind;
    String creamer;
}
