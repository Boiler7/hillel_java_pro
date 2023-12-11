package bank.api.converter;

import bank.WebIntegrationTest;
import bank.api.converter.model.ConverterResponse;
import bank.api.converter.model.ConverterResponseData;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DummyControllerIntegrationTest extends WebIntegrationTest {
    @Test
    public void shouldConvert() throws Exception {
        var response = ConverterResponse.builder()
                .data(Map.of("UAH", ConverterResponseData.builder()
                        .code("UAH")
                        .value(39.1425)
                        .build()))
                .build();

        wireMockServer.stubFor(WireMock.get(urlEqualTo("/api/converter"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(objectMapper.writeValueAsString(response))));

        var amount = mockMvc.perform(get("/api/converter")
                        .param("from", "USD")
                        .param("to", "UAH")
                        .param("amount", "100")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        double score = Double.parseDouble(amount);

        assertThat(score, equalTo(3914.25));
    }
}