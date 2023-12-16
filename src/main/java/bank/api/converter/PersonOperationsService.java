package bank.api.converter;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@AllArgsConstructor
@Slf4j
@Service
public class PersonOperationsService {
    private final CurrencyConverter currencyConverter;
    public double convert(Currency from, Currency to, double amount) throws ExecutionException, InterruptedException {
        CompletableFuture<Double> collable
                =CompletableFuture.supplyAsync(() -> currencyConverter.convert(from, to, amount));

        log.info("Convert: return={}", collable.get());

        return collable.get();
    }
}
