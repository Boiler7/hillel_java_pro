package bank.account;

public record AccountDto (
    String id,
    String iban,
    Integer balance,
    Long person_id
){

}
