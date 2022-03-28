package com.welltestedlearning.coffeekiosk.domain;

public class CoffeeItem {
    private Long id;
    private final String size;
    private final String kind;
    private final String creamer;

    public CoffeeItem(String size, String kind, String creamer) {
        this.size = size.toLowerCase();
        this.kind = kind.toLowerCase();
        this.creamer = creamer.toLowerCase();
    }

    public String kind() {
        return kind;
    }

    public String size() {
        return size;
    }

    public String creamer() {
        return creamer;
    }

    public int price() {
        switch (size) {
            case "small":
                return 1;
            case "medium":
                return 2;
            case "large":
                return 3;
            default:
                return 0;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
