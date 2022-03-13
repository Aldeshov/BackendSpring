package com.welltestedlearning.coffeekiosk;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CoffeeItemResponse {
    Long id;
    int price;
    String kind;
    String size;
    String creamer;

    public static CoffeeItemResponse from(CoffeeItem coffeeItem) {
        return new CoffeeItemResponse(
                coffeeItem.getId(),
                coffeeItem.price(),
                coffeeItem.kind(),
                coffeeItem.size(),
                coffeeItem.creamer()
        );
    }
}
