package bank;

import bank.account.AccountRepository;
import bank.api.converter.CurrencyProperties;
import bank.api.converter.CurrencyProperties;
import bank.card.CardRepository;
import bank.person.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
//import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

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

    @Autowired
    protected WireMockServer wireMockServer;

    @DynamicPropertySource
    public static void registerDynamicProperties(DynamicPropertyRegistry registry) {
        registry.add("wiremock.baseurl", WireMockConfig.wireMockServer::baseUrl);
    }

    @AfterEach
    public void tearDownWireMock() {
        wireMockServer.resetAll();
    }
}
