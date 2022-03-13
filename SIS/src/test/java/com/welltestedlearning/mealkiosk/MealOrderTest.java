package com.welltestedlearning.mealkiosk;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MealOrderTest {

    @Test
    public void emptyMealIsZeroPrice() {
        MealOrder mealOrder = new MealOrder();

        assertThat(mealOrder.price())
                .isZero();
    }

    @Test
    public void mealWithCheeseBurgerIs6() {
        MealOrder mealOrder = new MealOrder(BurgerTopping.CHEESE);

        assertThat(mealOrder.price())
                .isEqualTo(6);
    }

    @Test
    public void mealWithRegularBurgerLargeDrinkCosts7() {
        MealOrder mealOrder = new MealOrder(DrinkOption.LARGE);
        mealOrder.addBurger();

        assertThat(mealOrder.price())
                .isEqualTo(7);
    }

    @Test
    public void mealWithChickenSandwichRegularDrink() {
        MealOrder mealOrder = new MealOrder(DrinkOption.REGULAR);
        mealOrder.addChickenSandwich();

        assertThat(mealOrder.price())
                .isEqualTo(7);
    }

}
