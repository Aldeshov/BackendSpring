package com.welltestedlearning.coffeekiosk;

import com.welltestedlearning.coffeekiosk.domain.CoffeeOrderRepository;
import com.welltestedlearning.coffeekiosk.domain.InMemoryCoffeeOrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoffeeOrderRepositoryConfig {
    @Bean
    public CoffeeOrderRepository inMemoryCoffeeOrderRepository() {
        return new InMemoryCoffeeOrderRepository();
    }
}
