package com.welltestedlearning.mealkiosk;

public class MealBuilder {
    private String burgerOrder = "";
    private String drinkSize = "";

    private Toppings parseToppings(String toppingsText) {
        Toppings toppings = new Toppings();
        if (!toppingsText.equals("none")) {
            if (toppingsText.contains("avocado"))
                toppings.add(BurgerTopping.AVOCADO);
            if (toppingsText.contains("cheese"))
                toppings.add(BurgerTopping.CHEESE);
            if (toppingsText.contains("bacon"))
                toppings.add(BurgerTopping.BACON);
        }
        return toppings;
    }

    public void withDrink(String drinkOrderText) {
        drinkSize = drinkOrderText;
    }

    public void addBurgerString(String burgerOrderText) {
        burgerOrder += (burgerOrderText + " ");
    }

    public MealOrder build() {
        Toppings toppings = parseToppings(burgerOrder);
        Burger burger = new Burger(toppings);

        MealOrder mealOrder = new MealOrder();
        mealOrder.addItem(burger);

        if (drinkSize.contains(Drink.DRINK_LARGE))
            mealOrder.addItem(new Drink(Drink.DRINK_LARGE));
        if (drinkSize.contains(Drink.DRINK_REGULAR))
            mealOrder.addItem(new Drink(Drink.DRINK_REGULAR));

        return mealOrder;
    }
}