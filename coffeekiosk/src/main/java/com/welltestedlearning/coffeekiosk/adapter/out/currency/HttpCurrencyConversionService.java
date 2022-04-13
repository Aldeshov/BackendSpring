package com.welltestedlearning.coffeekiosk.adapter.out.currency;

import com.welltestedlearning.coffeekiosk.domain.ConvertedCurrency;
import com.welltestedlearning.coffeekiosk.domain.CurrencyConversionService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Profile("prod")
public class HttpCurrencyConversionService implements CurrencyConversionService {
    @Override
    public int convertToBritishPound(int amount) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://jitterted-currency-conversion.herokuapp.com/convert?from={from}&to={to}&amount={amount}";

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", "USD");
        uriVariables.put("to", "GBP");
        uriVariables.put("amount", amount + "");

        ConvertedCurrency response = restTemplate.getForObject(url, ConvertedCurrency.class, uriVariables);
        assert response != null;
        return response.getConverted().byteValue();
    }
}
