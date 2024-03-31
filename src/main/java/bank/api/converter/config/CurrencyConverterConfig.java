package bank.api.converter.config;

import bank.api.converter.CurrencyApiCurrencyConverter;
import bank.api.converter.CurrencyConverter;
import bank.api.converter.CurrencyProperties;
import bank.api.converter.DummyCurrencyConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CurrencyConverterConfig {
@Configuration
    @ConditionalOnProperty(name = "currency-converter.provider", havingValue = "currency")
    public static class ConverterConfiguration {
        @Bean
        public ApiCurrencyConverter currencyConverter(CurrencyProperties properties) {
            return new ApiCurrencyConverter(properties);
        }
    }

    @Configuration
    @ConditionalOnProperty(name = "currency-converter.provider", havingValue = "dummy", matchIfMissing = true)
    public static class DummyConverterConfiguration {
        @Bean
        public CurrencyConverter dummyCurrencyConverter() {
            return new DummyCurrencyConverter();
        }
    }
}

