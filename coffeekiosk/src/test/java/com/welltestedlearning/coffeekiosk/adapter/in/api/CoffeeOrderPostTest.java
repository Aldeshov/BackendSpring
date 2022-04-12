package com.welltestedlearning.coffeekiosk.adapter.in.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.welltestedlearning.coffeekiosk.adapter.in.api.CoffeeOrderRequest;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrder;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CoffeeOrderPostTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @Autowired
  CoffeeOrderRepository coffeeOrderRepository;

  @Test
  public void postCreatesOrderInRepository() throws Exception {
    CoffeeOrderRequest coffeeOrderRequest =
            new CoffeeOrderRequest("Customer Name", "large", "latte", "soy milk");
    String jsonRequest = objectMapper.writeValueAsString(coffeeOrderRequest);

    mockMvc.perform(post("/api/coffee/orders")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
           .andExpect(status().isCreated());

    assertThat(coffeeOrderRepository.findAll())
        .extracting(CoffeeOrder::customerName)
        .contains("Customer Name");
  }

}
