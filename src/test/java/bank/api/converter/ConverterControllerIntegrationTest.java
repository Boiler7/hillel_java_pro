package bank.api.converter;

import bank.WebIntegrationTest;
import bank.api.converter.model.ConverterResponse;
import bank.api.converter.model.ConverterResponseData;
import com.github.tomakehurst.wiremock.client.WireMock;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
public class ConverterControllerIntegrationTest extends WebIntegrationTest {
    @Test
    public void shouldConvert() throws Exception {
        var response = ConverterResponse.builder()
                .data(Map.of("USD", ConverterResponseData.builder()
                        .code("USD")
                        .value(39.1425)
                        .build()))
                .build();

        wireMockServer.stubFor(WireMock.get(urlEqualTo("/api/converter"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(objectMapper.writeValueAsString(response))));

        var responseBody = mockMvc.perform(get("/api/converter")
                        .param("from", "UAH")
                        .param("to", "USD")
                        .param("amount", "100")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        // Parse the JSON response and extract the numeric value


        assertThat(Math.round(Double.parseDouble(responseBody)), equalTo(Math.round(3675.5414059626587)));
    }



}