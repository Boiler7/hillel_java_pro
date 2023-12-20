package bank.api.converter.config;

import bank.api.converter.CurrencyApiCurrencyConverter;
import bank.api.converter.CurrencyConverter;
import bank.api.converter.CurrencyProperties;
import bank.api.converter.DummyCurrencyConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class CurrencyConverterConfig {

    @ConditionalOnProperty(name = "currency.converter.provider", havingValue = "currencyapi")
    public static class ConverterConfiguration {
        @Bean
        public CurrencyApiCurrencyConverter creditScoreService(CurrencyProperties properties) {
            return new CurrencyApiCurrencyConverter(properties, WebClient.builder().build());
        }
    }

    @Configuration
    @ConditionalOnProperty(name = "currency.converter.provider", havingValue = "dummy", matchIfMissing = true)
    public static class DummyConverterConfiguration {
        @Bean
        public CurrencyConverter dummyCurrencyConverter() {
            return new DummyCurrencyConverter();
        }
    }
}

