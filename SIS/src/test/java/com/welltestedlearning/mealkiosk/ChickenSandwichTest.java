package com.welltestedlearning.mealkiosk;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChickenSandwichTest {

    @Test
    public void baseChickenSandwichCosts6() {
        ChickenSandwich chickenSandwich = new ChickenSandwich();

        assertThat(chickenSandwich.price())
                .isEqualTo(6);
    }

    @Test
    public void isItHotInHereTrue() {
        ChickenSandwich chickenSandwich = new ChickenSandwich();

        assertThat(chickenSandwich.isSpicy())
                .isTrue();
    }

    @Test
    public void isItHotInHereFalse() {
        ChickenSandwich chickenSandwich = new ChickenSandwich(false);

        assertThat(chickenSandwich.isSpicy())
                .isFalse();
    }

    @Test
    public void chickenSandwichWithBurgerCosts7() {
        ChickenSandwich chickenSandwich = new ChickenSandwich();
        chickenSandwich.addTopping(BurgerTopping.CHEESE);

        assertThat(chickenSandwich.price())
                .isEqualTo(7);
    }
}
