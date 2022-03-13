package com.welltestedlearning.mealkiosk;

public enum BurgerTopping {
    BACON(2),
    CHEESE(1),
    AVOCADO(3);

    private final int price;

    BurgerTopping(int price) {
        this.price = price;
    }

    public int price() {
        return price;
    }
}
