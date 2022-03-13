package com.welltestedlearning.mealkiosk;

import java.util.Scanner;

public class MealKioskConsole {

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What toppings do you want on your Burger? none, cheese, bacon, avocado; default=none");
            String toppings = scanner.nextLine().toLowerCase();
            Burger burger = new Burger();
            if (!toppings.equals("none")) {
                if (toppings.contains("avocado"))
                    burger.addTopping(BurgerTopping.AVOCADO);
                if (toppings.contains("cheese"))
                    burger.addTopping(BurgerTopping.CHEESE);
                if (toppings.contains("bacon"))
                    burger.addTopping(BurgerTopping.BACON);
            }
            System.out.println("What size of drink do you want? regular, large; default=regular");
            String drinkSize = scanner.nextLine().toLowerCase();
            Drink drink = new Drink(Drink.DRINK_REGULAR);
            if (drinkSize.contains(Drink.DRINK_LARGE))
                drink = new Drink(Drink.DRINK_LARGE);

            MealOrder mealOrder = new MealOrder();
            mealOrder.addItem(burger);
            mealOrder.addItem(drink);

            mealOrder.display();

            System.out.println("Do you want to order another one? (y, yes), (n, no); default=(n, no)");
            String order = scanner.nextLine().toLowerCase();
            if (order.contains("n") || order.contains("no"))
                break;
            if (order.contains("y") || order.contains("yes")) {
                System.out.println();
                continue;
            }
            return;
        }
    }
}
