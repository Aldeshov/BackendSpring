package com.welltestedlearning.mealkiosk;

public class ChickenSandwich implements MenuItem {
    private final Toppings toppings = new Toppings();
    private boolean spicy = true;

    public ChickenSandwich() { }
    public ChickenSandwich(boolean spicy) {
        setSpicy(spicy);
    }

    public boolean isSpicy() {
        return spicy;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }

    public void addTopping(BurgerTopping burgerTopping) {
        toppings.add(burgerTopping);
    }

    @Override
    public int price() {
        return 6 + toppings.price();
    }

    @Override
    public void display() {
        System.out.println("ChickenSandwich: " + toppings);
    }

    @Override
    public String toString() {
        return "ChickenSandwich {\n" +
                "\ttoppings=" + toppings +
                "\n}";
    }
}
