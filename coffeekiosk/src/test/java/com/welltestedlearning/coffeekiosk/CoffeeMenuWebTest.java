package com.welltestedlearning.coffeekiosk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CoffeeMenuController.class)
public class CoffeeMenuWebTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getFromCoffeeSizesEndpointReturns200Ok() throws Exception {
        mockMvc.perform(get("/api/coffee/menu/sizes"))
                .andExpect(status().isOk());
    }
}