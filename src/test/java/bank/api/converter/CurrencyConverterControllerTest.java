package bank.api.converter;

import bank.WebIntegrationTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CurrencyConverterControllerTest extends WebIntegrationTest {

//    @Test
//    void shouldConvert() throws Exception {
//        var body =mockMvc.perform(get("/api/converter")
//                        .param("from", "USD")
//                        .param("to", "UAH")
//                        .param("amount", "100")
//                        .contentType(APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//
//        double result = Double.parseDouble(body);
//
//        assertThat(result, equalTo(3914.25));
//    }
}