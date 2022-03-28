package com.welltestedlearning.coffeekiosk.adapter.in.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeMenuController {
    @GetMapping("/api/coffee/menu/sizes")
    public String getCoffeeSizes() {
        return "small";
    }
}
