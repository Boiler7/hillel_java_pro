package bank.api.converter;

import bank.api.converter.model.ConverterResponse;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Currency;

public class CurrencyApiCurrencyConverter implements CurrencyConverter{
    private final WebClient webClient = WebClient.create();
    private final CurrencyProperties props;
    public CurrencyApiCurrencyConverter(CurrencyProperties props){
        this.props = props;
    }

    @Override
    public double convert(Currency from, Currency to, double amount) {
        ConverterResponse converterResponse =webClient.get()
                .uri(props.getUrl() +  "?apikey=" + props.getApiKey() + "&base_currency=" + from.getCurrencyCode()
                        + "&currencies=" + to.getCurrencyCode())
                .retrieve()
                .bodyToMono(ConverterResponse.class)
                .block();

        System.out.println(converterResponse);
        var data = converterResponse.getData()
                .orElseThrow(() -> new RuntimeException("Failed to retrieve conversion data"));

        return amount / data.getValue();
    }
}
