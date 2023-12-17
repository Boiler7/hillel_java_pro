package bank.card;

import bank.NumberGenerator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record CardDto(
    String id,
    @JsonProperty("person_id")
    String personId,
    @JsonProperty("account_id")
    String accountId,
    CardStatus cardStatus,
    String expirationDate,
    String pan,
    String pin,
    String cvv){
    public CardDto(String id, String personId, String accountId){
        this(id, personId, accountId, CardStatus.WAITING, NumberGenerator.getShortExpirationDate(NumberGenerator.generateExpirationDate()),
                NumberGenerator.generatePAN(),NumberGenerator.generatePIN(), NumberGenerator.generateCVV());
    }
}
