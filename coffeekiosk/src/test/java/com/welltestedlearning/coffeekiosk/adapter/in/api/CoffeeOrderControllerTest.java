package com.welltestedlearning.coffeekiosk.adapter.in.api;

import com.welltestedlearning.coffeekiosk.adapter.out.currency.StubCurrencyConversionService;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrder;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrderRepository;
import com.welltestedlearning.coffeekiosk.domain.InMemoryCoffeeOrderRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class CoffeeOrderControllerTest {

    @Test
    public void getWithPoundQueryParamConvertsPriceToPounds() throws Exception {
        // Given: an order is in the repository
        CoffeeOrderRepository coffeeOrderRepository = new InMemoryCoffeeOrderRepository();
        // empty coffee order is fine as the price will be ignored for this test
        CoffeeOrder coffeeOrder = new CoffeeOrder("Spring", LocalDateTime.now());
        coffeeOrder.setId(12L); // need to have an id, so we know we get an existing order
        coffeeOrderRepository.save(coffeeOrder);

        CoffeeOrderController controller =
                new CoffeeOrderController(coffeeOrderRepository, new StubCurrencyConversionService());

        // When: we do a GET with "gbp" currency
        CoffeeOrderResponse response = controller.coffeeOrder(coffeeOrder.getId(), "gbp").getBody();

        // Then: price will always be 1234, because that's what the Stub says
        assertThat(response.getTotalPrice())
                .isEqualTo("1234");
    }

}
