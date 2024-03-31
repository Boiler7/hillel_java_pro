package bank.api.converter;

import bank.WebIntegrationTest;
import bank.api.converter.model.ConverterResponse;
import bank.api.converter.model.ConverterResponseData;
import com.github.tomakehurst.wiremock.client.WireMock;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
public class ConverterControllerIntegrationTest extends WebIntegrationTest {
    @Test
    public void shouldConvert() throws Exception {
        var responseData = ConverterResponseData.builder()
                .code("UAH")
                .value(38)
                .build();

        var response = ConverterResponse.builder()
                .data(Map.of("UAH", responseData))
                .build();

        wireMockServer.stubFor(WireMock.get(WireMock.urlPathEqualTo("/converter"))
                .withQueryParam("apikey", WireMock.equalTo("123"))
                .withQueryParam("base_currency", WireMock.equalTo("USD"))
                .withQueryParam("currencies", WireMock.equalTo("UAH"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(objectMapper.writeValueAsString(response))));

        var mockResponse = mockMvc.perform(get("/api/converter")
                        .param("from", "USD")
                        .param("to", "UAH")
                        .param("amount", "100")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        var body = Double.parseDouble(mockResponse);

        assertThat(body, CoreMatchers.equalTo(3800.0));
    }
}