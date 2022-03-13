package com.welltestedlearning.mealkiosk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Drink implements MenuItem {

    public static final String DRINK_REGULAR = "regular";
    public static final String DRINK_LARGE = "large";

    private String size = ""; // regular or large

    private static final Logger LOGGER = LoggerFactory.getLogger(Drink.class);

    public Drink() {
    }

    public Drink(String drinkSize) {
        validateSize(drinkSize);
        size = drinkSize;
    }

    private void validateSize(String drinkSize) {
        if (drinkSize.equalsIgnoreCase(DRINK_LARGE) || drinkSize.equalsIgnoreCase(DRINK_REGULAR)) {
            return;
        }
        throw new DrinkSizeNotValidException("Drink size `" + drinkSize + "` not recognized.");
    }

    @Override
    public int price() {
        int price = 0;
        if (size.equals(DRINK_REGULAR)) {
            price = 1;
        } else if (size.equals(DRINK_LARGE)) {
            price = 2;
        }
        return price;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Drink Size: " + size;
    }
}
