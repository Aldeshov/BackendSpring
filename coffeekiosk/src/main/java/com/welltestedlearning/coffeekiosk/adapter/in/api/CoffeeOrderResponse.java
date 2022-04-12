package com.welltestedlearning.coffeekiosk.adapter.in.api;

import com.welltestedlearning.coffeekiosk.domain.CoffeeItemResponse;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrder;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class CoffeeOrderResponse {
  private long id;
  private String customerName;
  private String orderDateTime;
  private List<CoffeeItemResponse> coffeeItems;
  private String totalPrice;

  public static CoffeeOrderResponse from(CoffeeOrder coffeeOrder, String pricePrefix) {
    CoffeeOrderResponse coffeeOrderResponse = new CoffeeOrderResponse();
    coffeeOrderResponse.setId(coffeeOrder.getId());
    coffeeOrderResponse.setCustomerName(coffeeOrder.customerName());
    coffeeOrderResponse.setOrderDateTime(coffeeOrder.orderDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    coffeeOrderResponse.setTotalPrice("$" + pricePrefix);

    List<CoffeeItemResponse> coffeeItemResponses = coffeeOrder.coffeeItems()
                                                              .stream()
                                                              .map(CoffeeItemResponse::from)
                                                              .collect(Collectors.toList());
    coffeeOrderResponse.setCoffeeItems(coffeeItemResponses);

    return coffeeOrderResponse;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getOrderDateTime() {
    return orderDateTime;
  }

  public void setOrderDateTime(String orderDateTime) {
    this.orderDateTime = orderDateTime;
  }

  public String getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(String totalPrice) {
    this.totalPrice = totalPrice;
  }

  public List<CoffeeItemResponse> getCoffeeItems() {
    return coffeeItems;
  }

  public void setCoffeeItems(List<CoffeeItemResponse> coffeeItems) {
    this.coffeeItems = coffeeItems;
  }
}
