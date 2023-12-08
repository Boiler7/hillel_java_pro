package bank.api.converter;

import bank.WebIntegrationTest;
import org.junit.jupiter.api.Test;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CurrencyConverterControllerTest extends WebIntegrationTest {

    @Test
    void shouldConvert() throws Exception {
        mockMvc.perform(get("/api/converter")
                        .param("from", "USD")
                        .param("to", "UAH")
                        .param("amount", "100")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}