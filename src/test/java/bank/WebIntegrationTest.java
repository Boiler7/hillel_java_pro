package bank;

import bank.account.AccountRepository;
import bank.person.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
    protected WireMockServer wireMockServer;

//    @AfterAll
//    void tearDown() {
//        wireMockServer.resetAll();
//    }

    @DynamicPropertySource
    public static void registerDynamicProperties(DynamicPropertyRegistry registry) {
        registry.add("wiremock.baseurl", WireMockConfig.wireMockServer::baseUrl);
    }
}
