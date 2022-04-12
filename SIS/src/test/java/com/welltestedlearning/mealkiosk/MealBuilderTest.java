package com.welltestedlearning.mealkiosk;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MealBuilderTest {
    @Test
    public void orderWithBurgerNoneRegularDrinkCosts6() {
        MealBuilder mealBuilder = new MealBuilder();
        mealBuilder.addBurgerString("none");
        mealBuilder.withDrink("regular");

        MealOrder mealOrder = mealBuilder.build();
        assertThat(mealOrder.price()).isEqualTo(6);
    }
}
