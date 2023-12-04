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
                .build());

        var account = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .balance(159)
                .iban(NumberGenerator.generateIBAN())
                        .person(person)
                .build());

        mockMvc.perform(get("/api/accounts/{id}", account.getUid()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.iban", equalTo(account.getIban())));
    }

    @Test
    void shouldCreateAccount() throws Exception {
        var person = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Test")
                .build());

        var request = new AccountDto(null, 0, person.getUid());

        var body = mockMvc.perform(post("/api/accounts")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(notNullValue())))
                .andExpect(jsonPath("$.iban", equalTo(request.iban())))
                .andExpect(jsonPath("$.balance", equalTo(request.balance())))
                .andExpect(jsonPath("$.person_id").value(request.personId()))
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
                .build());

        var request = new AccountDto(null, NumberGenerator.generateIBAN(), 0, person.getUid());

        var body = mockMvc.perform(post("/api/accounts")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        var entityId = objectMapper.readValue(body, AccountDto.class).id();

        var updatedBalance = 100;
        var updateRequest = new AccountDto(entityId, request.iban(), updatedBalance, request.personId());

        var updatedBody = mockMvc.perform(put("/api/accounts/{id}", entityId)
                        .content(objectMapper.writeValueAsString(updateRequest))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        var updatedAccount = objectMapper.readValue(updatedBody, AccountDto.class);
        assertThat(updatedAccount.id(), equalTo(entityId));
        assertThat(updatedAccount.iban(), equalTo(request.iban()));
        assertThat(updatedAccount.balance(), equalTo(updatedBalance));
        assertThat(updatedAccount.personId(), equalTo(request.personId()));
    }

    @Test
    @Transactional
    void shouldDeletePerson() throws Exception {
        var person = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Test")
                .build());

        var account = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .balance(159)
                .iban(NumberGenerator.generateIBAN())
                .person(person)
                .build());

        mockMvc.perform(delete("/api/accounts/{id}", account.getUid())
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

        assertThat(accountRepository.findByUid(account.getPerson().getUid(), ));
    }
}
