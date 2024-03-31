package bank.api.converter;

import java.util.Currency;

public interface CurrencyConverter {
    public double convert(String from, String to, double amount);

}
