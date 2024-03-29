package bank;

import bank.account.AccountRepository;
import bank.api.converter.CurrencyProperties;
import bank.card.CardRepository;
import bank.person.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public abstract class WebIntegrationTest {
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected PersonRepository personRepository;
    @Autowired
    protected AccountRepository accountRepository;
    @Autowired
    protected ObjectMapper objectMapper;
    @Autowired
    protected CardRepository cardRepository;
    @Autowired
    protected CurrencyProperties properties;
}
