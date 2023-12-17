package bank.card;

import bank.WebIntegrationTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
class CardControllerTest extends WebIntegrationTest {
    @Test
    void shouldOpenCard() throws Exception {
//        var person = personRepository.save(Person.builder()
//                .uid(UUID.randomUUID().toString())
//                .name("Test")
//                .build());
//
//        var account = accountRepository.save(Account.builder()
//                .uid(UUID.randomUUID().toString())
//                .iban(NumberGenerator.generateIBAN())
//                .balance(150)
//                .person(person)
//                .build());


//        var cardRequest = new CardDto(UUID.randomUUID().toString(), account.getUid(), person.getUid());

//        mockMvc.perform(post("/api/persons/{personId}/accounts/{accountId}/cards",
//                        cardRequest.personId(), cardRequest.accountId())
////                        .content(objectMapper.writeValueAsString(cardRequest))
//                        .contentType(APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id", is(notNullValue())))
//                .andExpect(jsonPath("$.pan", equalTo(cardRequest.pan())))
//                .andExpect(jsonPath("$.pin", equalTo(cardRequest.pin())))
//                .andExpect(jsonPath("$.account_id", equalTo(cardRequest.accountId())))
//                .andExpect(jsonPath("$.person_id", equalTo(cardRequest.personId())))
//                .andExpect(jsonPath("$.expirationDate", equalTo(cardRequest.expirationDate())))
//                .andExpect(jsonPath("$.pin", equalTo(cardRequest.pin())))
//                .andExpect(jsonPath("$.cvv", equalTo(cardRequest.cvv())))
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
    }
}
