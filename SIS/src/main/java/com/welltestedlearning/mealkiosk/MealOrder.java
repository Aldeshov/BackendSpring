package com.welltestedlearning.mealkiosk;

import java.util.ArrayList;
import java.util.List;

public class MealOrder {
    private final List<MenuItem> items = new ArrayList<>();

    public static MealOrder createBurgerOnlyOrder(BurgerTopping burgerOption) {
        return new MealOrder(burgerOption);
    }

    public static void main(String[] args) {
        MealOrder drinkOrder = new MealOrder();
        drinkOrder.addDrink(Drink.DRINK_LARGE);
        drinkOrder.display();

        MealOrder burgerOrder = new MealOrder();
        burgerOrder.display();
    }

    public MealOrder() {
    }

    public MealOrder(BurgerTopping burgerOption) {
        addBurger(burgerOption);
    }

    public void addItem(MenuItem menuItem) {
        items.add(menuItem);
    }

    public void addDrink(String drinkSize) {
        items.add(new Drink(drinkSize));
    }

    public void addFries(String friesSize) {
        items.add(new Fries(friesSize));
    }

    public void addBurger() {
        items.add(new Burger());
    }

    public void addBurger(BurgerTopping burgerOption) {
        items.add(new Burger(burgerOption));
    }

    public void addChickenSandwich() {
        items.add(new ChickenSandwich());
    }

    public MealOrder(BurgerTopping burger, DrinkOption drink) {
        addBurger(burger);
        addDrink(drink.name().toLowerCase());
    }

    public MealOrder(DrinkOption drink) {
        addDrink(drink.name().toLowerCase());
    }

    public int price() {
        // loop over all items and sum their price
        int price = 0;
        for (MenuItem item : items) {
            price = price + item.price();
        }
        return price;
    }

    public void display() {
        System.out.println("---------------    Your-Order    ---------------");
        for (MenuItem item : items) {
            item.display();
        }
        System.out.println("Price: " + price() + "$");
        System.out.println("------------------------------------------------");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (MenuItem menuItem : items) {
            stringBuilder.append(menuItem);
            if (items.size() > 1)
                stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }
}

