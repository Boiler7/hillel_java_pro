package bank.api.converter;

import bank.api.converter.model.ConverterResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Currency;

@Slf4j
@RequiredArgsConstructor
@Service
public class ApiCurrencyConverter implements CurrencyConverter {
    private final WebClient webClient = WebClient.builder().build();
    private final CurrencyProperties config;

    @Override
    public double convert(Currency from, Currency to, double amount) {
        var result = webClient.get()
                .uri(config.getUrl(), uri -> uri.queryParam("apikey", config.getApiKey())
                        .queryParam("base_currency", from.getCurrencyCode())
                        .queryParam("currencies", to.getCurrencyCode())
                        .build())
                .retrieve()
                .bodyToMono(ConverterResponse.class)
                .block();

        log.info("result: {}", result);

        return result.getData().get(to.getCurrencyCode()).getValue() * amount;
    }
}
