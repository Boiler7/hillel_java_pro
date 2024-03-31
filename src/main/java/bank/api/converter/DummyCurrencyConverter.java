package bank.api.converter;

import java.util.Currency;

public class DummyCurrencyConverter implements CurrencyConverter{

    @Override
    public double convert(String from, String to, double amount) {
        return 3914.25;
    }
}
