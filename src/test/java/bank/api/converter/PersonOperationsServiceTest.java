package bank.api.converter;

import org.junit.jupiter.api.Test;

import java.util.Currency;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class PersonOperationsServiceTest {

    @Test
    void shouldConvert() throws ExecutionException, InterruptedException {
        var converter = new PersonOperationsService(new DummyCurrencyConverter());
        var from = Currency.getInstance("USD");
        var to = Currency.getInstance("EUR");

        var result = converter.convert(from, to, 100);

        assertEquals(result, 3914.25);
    }
}