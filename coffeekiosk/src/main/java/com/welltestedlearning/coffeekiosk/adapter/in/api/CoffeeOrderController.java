package com.welltestedlearning.coffeekiosk.adapter.in.api;

import com.welltestedlearning.coffeekiosk.domain.CoffeeItem;
import com.welltestedlearning.coffeekiosk.domain.CoffeeItemResponse;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrder;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrderRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
public class CoffeeOrderController {
    @Value("${order.price.currency.prefix}")
    private String currencyPrefix;
    private final CoffeeOrderRepository coffeeOrderRepository;

    public CoffeeOrderController(CoffeeOrderRepository coffeeOrderRepository) {
        this.coffeeOrderRepository = coffeeOrderRepository;
    }

    @GetMapping(value = "/api/coffee/order")
    public CoffeeItemResponse getCoffeeOrder() {
        return CoffeeItemResponse.from(new CoffeeItem("small", "latte", "milk"));
    }

    @GetMapping("/api/coffee/orders/{id}")
    public ResponseEntity<CoffeeOrderResponse> coffeeOrder(@PathVariable("id") long orderId) {
        if (orderId < 0) throw new IllegalArgumentException("Invalid Order ID");
        if (coffeeOrderRepository.findById(orderId).isPresent()) {
            CoffeeOrder coffeeOrder = coffeeOrderRepository.findById(orderId).get();
            CoffeeOrderResponse response = CoffeeOrderResponse.from(coffeeOrder, currencyPrefix);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/coffee/orders")
    public ResponseEntity createCoffeeOrder(@RequestBody CoffeeOrderRequest coffeeOrderRequest) {
        CoffeeOrder coffeeOrder = new CoffeeOrder(coffeeOrderRequest.getCustomerName(), LocalDateTime.now());
        CoffeeItem coffeeItem = new CoffeeItem(coffeeOrderRequest.getSize(), coffeeOrderRequest.getKind(), coffeeOrderRequest.getCreamer());
        coffeeOrder.add(coffeeItem);
        CoffeeOrder savedCoffeeOrder = coffeeOrderRepository.save(coffeeOrder);
        return ResponseEntity.created(
                URI.create("/api/coffee/orders/" + savedCoffeeOrder.getId())
        ).build();
    }
}
