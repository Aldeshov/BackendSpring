package com.welltestedlearning.mealkiosk;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BurgerTest {

    @Test
    public void burgerWithNoToppingsCosts5() {
        Burger burger = new Burger();
        assertThat(burger.price()).isEqualTo(5);
    }

    @Test
    public void cheeseburgerCosts6() {
        Burger burger = new Burger(BurgerTopping.CHEESE);

        assertThat(burger.price())
                .isEqualTo(6);
    }

    @Test
    public void tests() {
        Burger burger = new Burger();
        burger.addTopping(BurgerTopping.CHEESE);
        assertThat(burger.price()).isEqualTo(6);

        burger.addTopping(BurgerTopping.CHEESE);
        assertThat(burger.price()).isEqualTo(7);

        burger.addTopping(BurgerTopping.BACON);
        assertThat(burger.price()).isEqualTo(9);
    }

}