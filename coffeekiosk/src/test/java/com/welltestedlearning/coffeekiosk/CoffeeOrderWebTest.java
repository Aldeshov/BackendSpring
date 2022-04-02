package com.welltestedlearning.coffeekiosk;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.welltestedlearning.coffeekiosk.adapter.in.api.CoffeeOrderController;
import com.welltestedlearning.coffeekiosk.adapter.in.api.CoffeeOrderResponse;
import com.welltestedlearning.coffeekiosk.domain.CoffeeItem;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrder;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CoffeeOrderController.class)
//@Import({CoffeeOrderRepositoryConfig.class, SampleDataLoader.class})
class CoffeeOrderWebTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    CoffeeOrderRepository coffeeOrderRepository;

    @BeforeEach
    public void initRepo() {
        CoffeeItem coffeeItem = new CoffeeItem("small", "latte", "milk");
        coffeeItem.setId(99L);
        CoffeeOrder coffeeOrder = new CoffeeOrder("Ted", LocalDateTime.of(2020, 10, 11, 12, 13));
        coffeeOrder.add(coffeeItem);
        coffeeOrder.setId(23L);
        org.mockito.Mockito.when(coffeeOrderRepository.findById(23L)).thenReturn(Optional.of(coffeeOrder));
    }

    @Test
    public void getCoffeeOrderIsOk() throws Exception {
        mockMvc.perform(get("/api/coffee/orders/23")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getCoffeeOrderIsCompleteJson() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/coffee/orders/23")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        CoffeeOrder coffeeOrder = createCoffeeOrderWithOneItemAndIdOf(23L);
        CoffeeOrderResponse expectedResponse = CoffeeOrderResponse.from(coffeeOrder);
        String expectedJson = objectMapper.writeValueAsString(expectedResponse);

        assertThat(mvcResult.getResponse().getContentAsString())
                .isEqualTo(expectedJson);
    }

    private CoffeeOrder createCoffeeOrderWithOneItemAndIdOf(long coffeeOrderId) {
        CoffeeItem coffeeItem = new CoffeeItem("small", "latte", "milk");
        coffeeItem.setId(99L);
        CoffeeOrder coffeeOrder = new CoffeeOrder("Ted", LocalDateTime.of(2020, 10, 11, 12, 13));
        coffeeOrder.add(coffeeItem);
        coffeeOrder.setId(coffeeOrderId);
        return coffeeOrder;
    }

    @Test
    public void getNonExistentCoffeeOrderReturnsNotFoundStatus() throws Exception {
        mockMvc.perform(get("/api/coffee/orders/9999")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getNegativeIdReturnsBadRequestStatus() throws Exception {
        mockMvc.perform(get("/api/coffee/orders/-1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

}