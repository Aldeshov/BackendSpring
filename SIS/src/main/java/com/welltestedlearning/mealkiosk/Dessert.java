package com.welltestedlearning.mealkiosk;

public class Dessert implements MenuItem {
    @Override
    public int price() {
        return 1;
    }

    @Override
    public void display() {
        System.out.println("Dessert");
    }
}
