package bank.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record TransactionDto(
        @JsonProperty("id")
        String id,
        @JsonProperty("from_card")
        String fromCard,
        @JsonProperty("to_card")
        String toCard,
        int amount) {
    public TransactionDto(String fromCard, String toCard, int amount){
        this(UUID.randomUUID().toString(), fromCard, toCard, amount);
    }
}
