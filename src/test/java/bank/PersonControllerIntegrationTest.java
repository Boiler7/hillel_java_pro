package bank;

import bank.person.Person;
import bank.person.PersonDto;
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

public class PersonControllerIntegrationTest extends WebIntegrationTest {
    @Test
    void shouldFindPerson() throws Exception {
        var person = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Test")
                .build());

        mockMvc.perform(get("/api/persons/{id}", person.getUid()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(person.getName())))
        ;
    }

    @Test
    void shouldCreatePerson() throws Exception {
        var request = new PersonDto(null, "Test" + UUID.randomUUID());

        var body = mockMvc.perform(post("/api/persons")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(notNullValue())))
                .andExpect(jsonPath("$.name", equalTo(request.name())))
                .andReturn()
                .getResponse()
                .getContentAsString();

        var entityId = objectMapper.readValue(body, PersonDto.class).id();
        var persistedPerson = personRepository.findByUid(entityId).orElseThrow();
        assertThat(persistedPerson.getName(), equalTo(request.name()));
        assertThat(persistedPerson.getCreatedAt(), is(notNullValue()));
        assertThat(persistedPerson.getUpdatedAt(), is(notNullValue()));
    }

    @Test
    void shouldUpdatePerson() throws Exception {
        var person = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Test")
                .build());

        var updateRequest = new PersonDto(null, "Test1");

        var updatedBody = mockMvc.perform(put("/api/persons/{id}", person.getUid())
                        .content(objectMapper.writeValueAsString(updateRequest))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        var updatedPerson = objectMapper.readValue(updatedBody, PersonDto.class);

        assertThat(updatedPerson.name(), equalTo(updateRequest.name()));
    }

    @Test
    @Transactional
    void shouldDeletePerson() throws Exception {
        var person = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Test")
                .build());

        mockMvc.perform(delete("/api/persons/{id}", person.getUid())
                        .contentType(APPLICATION_JSON))
            .andExpect(status().isOk());
    }

}
