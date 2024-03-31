package bank.api.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Currency;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CurrencyConverterController {
    private final CurrencyConverter currencyConverter;

    @GetMapping("/converter")
    public double converter(
            @RequestParam Currency from,
            @RequestParam Currency to,
            @RequestParam double amount){
        return currencyConverter.convert(from, to, amount);
    }
}
