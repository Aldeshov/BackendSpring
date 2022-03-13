package com.welltestedlearning.coffeekiosk;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CoffeeOrderController.class)
public class CoffeeOrderWebTest {
    // in tests, it's OK to do "field" Autowiring (injection)
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;


    @Test
    public void getFromCoffeeOrderEndpointIs200Ok() throws Exception {
        mockMvc.perform(get("/api/coffee/order")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getCoffeeOrderReturnsCompleteJson() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/coffee/order")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        CoffeeItem coffeeItem = new CoffeeItem("small", "latte", "milk");
//        coffeeItem.setId(1L);
        CoffeeItemResponse expectedResponse = CoffeeItemResponse.from(coffeeItem);
        String expectedJson = objectMapper.writeValueAsString(expectedResponse);

        assertThat(mvcResult.getResponse().getContentAsString())
                .isEqualTo(expectedJson);
    }
}
