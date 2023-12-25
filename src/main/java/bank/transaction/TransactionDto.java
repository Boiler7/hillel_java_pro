package bank.transaction;

public record TransactionDto(
        String fromCard,
        String toCard,
        int amount
) {
}
