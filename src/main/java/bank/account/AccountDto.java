package bank.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AccountDto (
    String id,
    String iban,
    Integer balance,
    @JsonProperty("person_id")
    String personId
)
{}