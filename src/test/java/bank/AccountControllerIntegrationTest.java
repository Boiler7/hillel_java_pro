package bank;

import bank.account.Account;
import bank.account.AccountDto;
import bank.person.Person;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AccountControllerIntegrationTest extends WebIntegrationTest{
    @Test
    void shouldFindAccount() throws Exception {
        var person = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Test")
                .uid(UUID.randomUUID().toString())
                .updatedAt(Instant.now())
                .createdAt(Instant.now())
                .build());

        var account = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .balance(159)
                .iban(NumberGenerator.generateIBAN())
                        .person(person)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build());

        mockMvc.perform(get("/api/accounts/{id}", account.getUid()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.iban", equalTo(account.getIban())))
        ;
    }

    @Test
    void shouldCreateAccount() throws Exception {
        var person = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Test")
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build());

        var request = new AccountDto(null, NumberGenerator.generateIBAN(), 0, person.getUid());

        var body = mockMvc.perform(post("/api/accounts")
                        .content( objectMapper.writeValueAsString(request))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(notNullValue())))
                .andExpect(jsonPath("$.iban", equalTo(request.iban())))
                .andExpect(jsonPath("$.balance", equalTo(request.balance())))
                .andExpect(jsonPath("$.personId", equalTo(request.personId())))
                .andReturn()
                .getResponse()
                .getContentAsString();

        var entityId = objectMapper.readValue(body, AccountDto.class).id();
        var persistedAccount = accountRepository.findByUid(entityId).orElseThrow();
        assertThat(persistedAccount.getIban(), equalTo(request.iban()));
        assertThat(persistedAccount.getBalance(), equalTo(request.balance()));
        assertThat(persistedAccount.getPerson().getUid(), equalTo(request.personId()));
        assertThat(persistedAccount.getCreatedAt(), is(notNullValue()));
        assertThat(persistedAccount.getUpdatedAt(), is(notNullValue()));
    }

    @Test
    void shouldUpdateAccount() throws Exception {
        var person = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Test")
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build());

        var initialRequest = new AccountDto(null, NumberGenerator.generateIBAN(), 0, person.getUid());

        var initialBody = mockMvc.perform(post("/api/accounts")
                        .content(objectMapper.writeValueAsString(initialRequest))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        var initialEntityId = objectMapper.readValue(initialBody, AccountDto.class).id();

        var updatedBalance = 100;
        var updateRequest = new AccountDto(initialEntityId, initialRequest.iban(), updatedBalance, initialRequest.personId());

        var updatedBody = mockMvc.perform(put("/api/accounts/{id}", initialEntityId)
                        .content(objectMapper.writeValueAsString(updateRequest))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        var updatedAccount = objectMapper.readValue(updatedBody, AccountDto.class);
        assertThat(updatedAccount.id(), equalTo(initialEntityId));
//        assertThat(updatedAccount.iban(), equalTo(initialRequest.iban()));
        assertThat(updatedAccount.balance(), equalTo(updatedBalance));
        assertThat(updatedAccount.personId(), equalTo(initialRequest.personId()));
    }

    @Test
    @Transactional
    void shouldDeletePerson() throws Exception {
        var person = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Test")
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build());

        var account = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .balance(159)
                .iban(NumberGenerator.generateIBAN())
                .person(person)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build());

        mockMvc.perform(delete("/api/accounts/{id}", account.getUid())
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
