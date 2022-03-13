package com.welltestedlearning.mealkiosk;

import java.util.ArrayList;

public class Toppings {
    private final ArrayList<BurgerTopping> toppings = new ArrayList<>();

    public void add(BurgerTopping burgerTopping) {
        this.toppings.add(burgerTopping);
    }

    public int price() {
        int price = 0;
        for (BurgerTopping burgerTopping : toppings)
            price += burgerTopping.price();
        return price;
    }

    @Override
    public String toString() {
        return "Toppings { " + "toppings=" + toppings + " }";
    }
}
