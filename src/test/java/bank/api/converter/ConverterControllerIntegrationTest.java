package bank.api.converter;

import bank.WebIntegrationTest;
import bank.api.converter.model.ConverterResponse;
import bank.api.converter.model.ConverterResponseData;
import com.github.tomakehurst.wiremock.client.WireMock;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
public class ConverterControllerIntegrationTest extends WebIntegrationTest {
    @Test
    public void shouldConvert() throws Exception {
        log.info("BaseUrl" + wireMockServer.baseUrl());
        var response = ConverterResponse.builder()
                .data(Map.of("UAH", ConverterResponseData.builder()
                        .code("UAH")
                        .value(39.1425)
                        .build()))
                .build();

        wireMockServer.stubFor(WireMock.get(urlPathEqualTo("/v3/latest"))
                .withQueryParam("apikey", WireMock.equalTo(properties.getApiKey()))
                .withQueryParam("base_currency", WireMock.equalTo("USD"))
                .withQueryParam("currencies", WireMock.equalTo("UAH"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(objectMapper.writeValueAsString(response))));

        log.info(wireMockServer.baseUrl()+wireMockServer.isRunning() );
        var responseBody = mockMvc.perform(get("/api/converter")
                        .param("from", "USD")
                        .param("to", "UAH")
                        .param("amount", "100.0")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();


        var result = Double.parseDouble(responseBody);
        assertThat(result, equalTo(3914.25));
    }
}