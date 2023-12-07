package bank.api.converter;

import java.util.Currency;

public interface CurrencyConverter {
    public double convert(Currency from, Currency to, double amount);
}
