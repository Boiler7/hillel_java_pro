package bank.card;

import bank.NumberGenerator;
import bank.WebIntegrationTest;
import bank.account.Account;
import bank.person.Person;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
class CardControllerTest extends WebIntegrationTest {
    @Test
    void shouldOpenCard() throws Exception {
        var person = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Test")
                .build());

        var account = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban(NumberGenerator.generateIBAN())
                .balance(150)
                .person(person)
                .build());

        var cardRequest = new CardDto(UUID.randomUUID().toString(), person.getUid(), account.getUid());

        mockMvc.perform(post("/api/persons/{personId}/accounts/{accountId}/cards",
                        cardRequest.personId(), cardRequest.accountId())
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(notNullValue())))
                .andExpect(jsonPath("$.account_id", equalTo(cardRequest.accountId())))
                .andExpect(jsonPath("$.person_id", equalTo(cardRequest.personId())))
                .andExpect(jsonPath("$.expirationDate", equalTo(cardRequest.expirationDate())))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }
}
