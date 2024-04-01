package bank.api.converter;

import bank.api.converter.model.ConverterResponse;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Currency;
import java.util.Objects;

//public class CurrencyApiCurrencyConverter implements CurrencyConverter {
//    private WebClient webClient;
//    private final CurrencyProperties props;
//
//    public CurrencyApiCurrencyConverter(CurrencyProperties props) {
//        this.props = props;
//        this.webClient = createWebClient(props.getUrl(), "Bearer " + props.getApiKey());
//    }
//
//    public CurrencyApiCurrencyConverter(CurrencyProperties props, WebClient webClient) {
//        this.props = props;
//        this.webClient = webClient;
//    }
//
//    private WebClient createWebClient(String baseUrl, String authorizationHeader) {
//        return WebClient.builder()
//                .baseUrl(baseUrl)
//                .defaultHeader("Authorization", authorizationHeader)
//                .build();
//    }
//
//
//    @Override
//    public double convert(String from, String to, double amount) {
//        var response = Objects.requireNonNull(webClient.get()
//                        .uri(uri -> uri.path("/v3/latest")
//                                .queryParam("apikey", props.getApiKey())
//                                .queryParam("base_currency", from)
//                                .queryParam("currencies", to)
//                                .build())
//                        .retrieve()
//                        .bodyToMono(ConverterResponse.class)
//                        .block())
//                .getData();
//
//        var data = response.entrySet().stream()
//                .filter(a -> a.getKey().equals(to))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Failed to retrieve conversion data"));
//
//        System.out.println(response);
//        return amount / data.getValue().getValue();
//    }
//}
