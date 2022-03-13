package com.welltestedlearning.mealkiosk;

public class Burger implements MenuItem {

    private final Toppings toppings = new Toppings();

    public Burger() { }
    public Burger(BurgerTopping theBurgerOption) {
        toppings.add(theBurgerOption);
    }

    public void addTopping(BurgerTopping burgerToppings) {
        toppings.add(burgerToppings);
    }

    @Override
    public int price() {
        return 5 + toppings.price();
    }

    public void display() {
        System.out.println("Burger: " + toppings);
    }

    @Override
    public String toString() {
        return "Burger {\n" +
                "\ttoppings=" + toppings +
                "\n}";
    }
}
