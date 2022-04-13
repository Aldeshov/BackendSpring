package com.welltestedlearning.coffeekiosk.adapter.out.currency;

import com.welltestedlearning.coffeekiosk.domain.CurrencyConversionService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class StubCurrencyConversionService implements CurrencyConversionService {
    @Override
    public int convertToBritishPound(int amount) {
        return 1234;
    }
}
