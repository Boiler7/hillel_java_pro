package bank.api.converter;

import bank.WebIntegrationTest;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DummyControllerIntegrationTest extends WebIntegrationTest {
    @Test
    public void shouldConvert() throws Exception {
        stubFor(WireMock.get(urlEqualTo("http://localhost:8080/api/converter"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")));

        var amount = mockMvc.perform(get("/api/converter")
                        .param("from", "UAH")
                        .param("to", "USD")
                        .param("amount", "100")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        var result = Double.parseDouble(amount);

        assertThat(result, equalTo(3914.25));
    }
}