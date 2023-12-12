package bank.api.converter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@AllArgsConstructor

@Service
public class PersonOperationsService {
    private final CurrencyConverter currencyConverter;
    public double convert(Currency from, Currency to, double amount) throws ExecutionException, InterruptedException {
        CompletableFuture<Double> collable
                =CompletableFuture.supplyAsync(() -> currencyConverter.convert(from, to, amount));

        return collable.get();
    }
}
