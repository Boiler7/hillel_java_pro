package bank.account;

import bank.person.Person;

public record AccountDto (
    String id,
    String iban,
    Integer balance,
    String personUid
)
{}