package com.welltestedlearning.coffeekiosk.adapter.in.api;

import com.welltestedlearning.coffeekiosk.domain.CoffeeItem;
import com.welltestedlearning.coffeekiosk.domain.CoffeeItemResponse;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrder;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeOrderController {
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
            CoffeeOrderResponse response = CoffeeOrderResponse.from(coffeeOrder);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }
}
