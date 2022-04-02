package com.welltestedlearning.coffeekiosk;

import com.welltestedlearning.coffeekiosk.domain.CoffeeItem;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrder;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SampleDataLoader implements CommandLineRunner {
    private final CoffeeOrderRepository coffeeOrderRepository;

    public SampleDataLoader(CoffeeOrderRepository coffeeOrderRepository) {
        this.coffeeOrderRepository = coffeeOrderRepository;
    }

    @Override
    public void run(String... args) {
        CoffeeItem coffeeItem = new CoffeeItem("small", "latte", "milk");
        coffeeItem.setId(99L);
        CoffeeOrder coffeeOrder = new CoffeeOrder("Ted", LocalDateTime.of(2020, 10, 11, 12, 13));
        coffeeOrder.add(coffeeItem);
        coffeeOrder.setId(23L);

        coffeeOrderRepository.save(coffeeOrder);
    }
}
