package com.welltestedlearning.mealkiosk;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MealOrderApiController {
    @PostMapping(value = "/api/mealorder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public MealOrderResponse mealOrder(@RequestBody MealOrderRequest mealOrderRequest) {
        MealBuilder mealBuilder = new MealBuilder();
        mealBuilder.addBurgerString(mealOrderRequest.getBurger());
        if (mealOrderRequest.getDrink() != null)
            mealBuilder.withDrink(mealOrderRequest.getDrink());
        MealOrder mealOrder = mealBuilder.build();

        int price = mealOrder.price();
        MealOrderResponse mealOrderResponse = new MealOrderResponse();
        mealOrderResponse.setPrice(price);
        return mealOrderResponse;
    }
}
