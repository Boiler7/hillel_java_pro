package bank.api.converter;

import bank.api.converter.model.ConverterResponse;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Currency;
import java.util.Objects;

public class CurrencyApiCurrencyConverter implements CurrencyConverter {
    private WebClient webClient;
    private final CurrencyProperties props;

    public CurrencyApiCurrencyConverter(CurrencyProperties props) {
        this.props = props;
        this.webClient = getWebClient();
    }

    private WebClient getWebClient() {
        if (webClient == null) {
            webClient = WebClient.builder().baseUrl(props.getUrl()).build();
        }
        return webClient;
    }

    @Override
    public double convert(Currency from, Currency to, double amount) {
        var converterResponse = Objects.requireNonNull(webClient.get()
                        .uri(uri -> uri.path("/v3/latest")
                                .queryParam("apikey", props.getApiKey())
                                .queryParam("base_currency", from.getCurrencyCode())
                                .queryParam("currencies", to.getCurrencyCode())
                                .build())
                        .retrieve()
                        .bodyToMono(ConverterResponse.class)
                        .block())
                .getData();

        System.out.println(converterResponse);
        var data = converterResponse.entrySet().stream().findAny()
                .orElseThrow(() -> new RuntimeException("Failed to retrieve conversion data"));


        return amount / data.getValue().getValue();
    }
}
