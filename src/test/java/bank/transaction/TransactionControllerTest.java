package bank.transaction;

import bank.NumberGenerator;
import bank.WebIntegrationTest;
import bank.account.Account;
import bank.card.Card;
import bank.card.CardStatus;
import bank.person.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
class TransactionControllerTest extends WebIntegrationTest {
    @Test
    void transaction() throws Exception {
        var personFrom = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Test")
                .build());

        var accountFrom = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban(NumberGenerator.generateIBAN())
                .balance(150)
                .person(personFrom)
                .build());

        var cardFrom = cardRepository.save(Card.builder()
                .uid(UUID.randomUUID().toString())
                .pan(NumberGenerator.generatePAN())
                .cvv(NumberGenerator.generateCVV())
                .cardStatus(CardStatus.ACTIVE)
                .pin(NumberGenerator.generatePIN())
                .expirationDate(NumberGenerator.generateExpirationDate())
                .person(personFrom)
                .account(accountFrom)
                .build());

        var personTo = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Test")
                .build());

        var accountTo = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban(NumberGenerator.generateIBAN())
                .balance(150)
                .person(personTo)
                .build());

        var cardTo = cardRepository.save(Card.builder()
                .uid(UUID.randomUUID().toString())
                .pan(NumberGenerator.generatePAN())
                .cvv(NumberGenerator.generateCVV())
                .cardStatus(CardStatus.ACTIVE)
                .pin(NumberGenerator.generatePIN())
                .expirationDate(NumberGenerator.generateExpirationDate())
                .person(personTo)
                .account(accountTo)
                .build());

        var transaction = new TransactionDto(cardFrom.getPan(), cardTo.getPan(), 150);

        var body = mockMvc.perform(post("/api/transactions")
                        .content(objectMapper.writeValueAsString(transaction))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$.id", is(notNullValue())))
//                .andExpect(jsonPath("$.fromCard", equalTo(transaction.fromCard())))
//                .andExpect(jsonPath("$.toCard", equalTo(transaction.toCard())))
//                .andExpect(jsonPath("$.amount", equalTo(transaction.amount())))
//                .andReturn()
//                .getResponse()
//                .getContentAsString();

//        var entityId = objectMapper.readValue(body, TransactionDto.class).id();
//        var transactionInBase = objectMapper.readValue(body, TransactionDto.class);
//        assertThat(transactionInBase.id(), equalTo(entityId));
//        assertThat(transactionInBase.fromCard(), equalTo(transaction.fromCard()));
//        assertThat(transactionInBase.toCard(), equalTo(transaction.toCard()));
//        assertThat(transactionInBase.amount(), equalTo(transaction.amount()));
    }
}