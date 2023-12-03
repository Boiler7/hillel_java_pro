package bank.account;

import bank.NumberGenerator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record AccountDto (
    String id,
    String iban,
    Integer balance,
    @JsonProperty("person_id")
    String personId
)
{
    public AccountDto(String id, Integer balance, String personId){
        this(id, NumberGenerator.generateIBAN(), balance, personId);
    }
}