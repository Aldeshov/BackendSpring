package com.welltestedlearning.coffeekiosk.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryCoffeeOrderRepository implements CoffeeOrderRepository {
    private final Map<Long, CoffeeOrder> coffeeOrderMap = new HashMap<>();
    private final AtomicLong sequence = new AtomicLong();

    @Override
    public Optional<CoffeeOrder> findById(Long id) {
        return Optional.ofNullable(coffeeOrderMap.get(id));
    }

    @Override
    public CoffeeOrder save(CoffeeOrder coffeeOrder) {
        assignIdTo(coffeeOrder);
        coffeeOrderMap.put(coffeeOrder.getId(), coffeeOrder);
        return coffeeOrder;
    }

    @Override
    public List<CoffeeOrder> findAll() {
        return new ArrayList<>(coffeeOrderMap.values());
    }

    private void assignIdTo(CoffeeOrder coffeeOrder) {
        if (coffeeOrder.getId() == null) {
            coffeeOrder.setId(sequence.getAndIncrement());
        }
        for (CoffeeItem coffeeItem : coffeeOrder.coffeeItems()) {
            if (coffeeItem.getId() == null) {
                coffeeItem.setId(sequence.getAndIncrement());
            }
        }
    }
}
