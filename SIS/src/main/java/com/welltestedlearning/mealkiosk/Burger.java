package com.welltestedlearning.mealkiosk;

public class Burger implements MenuItem {

    private Toppings toppings = new Toppings();

    public Burger() {
    }

    public Burger(Toppings toppings) {
        this.toppings = toppings;
    }

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
