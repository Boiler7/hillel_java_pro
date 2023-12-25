package bank.transaction;

import bank.account.AccountDto;
import bank.account.AccountService;
import bank.card.CardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final AccountService accountService;
    private final CardRepository cardRepository;

    @Transactional
    public void makeTransaction(TransactionDto transactionRequest) {
        var cardFrom = cardRepository.findByPan(transactionRequest.fromCard()).orElseThrow(()
                -> new RuntimeException("Sender's card is not found"));
        var cardTo = cardRepository.findByPan(transactionRequest.toCard()).orElseThrow(()
                -> new RuntimeException("Receiver's card is not found"));

        var balanceFrom = cardFrom.getAccount().getBalance();

        var accountId = cardFrom.getAccount().getUid();


        if (balanceFrom >= transactionRequest.amount() ){
            var accountFromUpdate = cardFrom.getAccount();

            accountService.update(accountId, new AccountDto(accountFromUpdate.getUid(), accountFromUpdate.getIban(),
                    accountFromUpdate.getBalance() - transactionRequest.amount(),
                    accountFromUpdate.getPerson().getUid()));


            var accountToUpdate = cardTo.getAccount();

            accountService.update(accountToUpdate.getUid(), new AccountDto(accountToUpdate.getIban(),
                    accountToUpdate.getBalance() + transactionRequest.amount(),
                    accountToUpdate.getPerson().getUid()));
        } else {
            throw new RuntimeException("No sufficient fonds");
        }
    }
}
