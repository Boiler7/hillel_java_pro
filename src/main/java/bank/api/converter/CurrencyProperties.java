package bank.api.converter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Configuration
@ConfigurationProperties(prefix = "currency")
public class CurrencyProperties {
    private String url;
    private String apiKey;
}
