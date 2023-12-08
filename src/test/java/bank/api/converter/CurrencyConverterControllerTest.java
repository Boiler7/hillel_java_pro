package bank.api.converter;

import bank.WebIntegrationTest;
import org.junit.jupiter.api.Test;

import java.util.Currency;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CurrencyConverterControllerTest extends WebIntegrationTest {

    @Test
    void shouldConvert() throws Exception {
        var body = mockMvc.perform(get("/api/converter")
                        .param("from", "USD")
                        .param("to", "UAH")
                        .param("amount", "100")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }
}