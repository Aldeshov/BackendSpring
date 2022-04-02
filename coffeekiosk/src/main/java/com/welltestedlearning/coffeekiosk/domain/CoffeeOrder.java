package com.welltestedlearning.coffeekiosk.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CoffeeOrder {
  private Long id;
  private final String customerName;
  private final LocalDateTime orderDateTime;
  private final List<CoffeeItem> coffeeItems = new ArrayList<>();

  public CoffeeOrder(String customerName, LocalDateTime orderDateTime) {
    this.customerName = customerName;
    this.orderDateTime = orderDateTime;
  }

  public int totalPrice() {
    return coffeeItems.stream()
                      .mapToInt(CoffeeItem::price)
                      .sum();
  }

  public void add(CoffeeItem coffeeItem) {
    coffeeItems.add(coffeeItem);
  }

  public List<CoffeeItem> coffeeItems() {
    return List.copyOf(coffeeItems);
  }

  public String customerName() {
    return customerName;
  }

  public LocalDateTime orderDateTime() {
    return orderDateTime;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
