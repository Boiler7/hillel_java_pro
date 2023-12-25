package bank.transaction;

import bank.NumberGenerator;
import bank.account.AccountDto;
import bank.account.AccountService;
import bank.card.CardRepository;
import hw31.mvc.ModelNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final AccountService accountService;
    private final CardRepository cardRepository;
    private final TransactionRepository transactionRepository;

    @Transactional
    public void makeTransaction(TransactionDto transactionRequest) {
        var cardFrom = cardRepository.findByPan(transactionRequest.fromCard()).orElseThrow(()
                -> new RuntimeException("Sender's card is not found"));
        var cardTo = cardRepository.findByPan(transactionRequest.toCard()).orElseThrow(()
                -> new RuntimeException("Receiver's card is not found"));

        var balanceFrom = cardFrom.getAccount().getBalance();

        if (balanceFrom >= transactionRequest.amount() ){
            var accountFromUpdate = cardFrom.getAccount();
            var accountToUpdate = cardTo.getAccount();

            accountService.update(accountFromUpdate.getUid(), new AccountDto(accountFromUpdate.getUid(), accountFromUpdate.getIban(),
                    accountFromUpdate.getBalance() - transactionRequest.amount(),
                    accountFromUpdate.getPerson().getUid()));

            accountService.update(accountToUpdate.getUid(), new AccountDto(accountToUpdate.getIban(),
                    accountToUpdate.getBalance() + transactionRequest.amount(),
                    accountToUpdate.getPerson().getUid()));

            transactionRepository.save(Transaction.builder()
                    .uid(UUID.randomUUID().toString())
                    .fromCard(cardFrom)
                    .fromAccount(accountFromUpdate)
                    .toCard(cardTo)
                    .toAccount(accountToUpdate)
                    .amount(transactionRequest.amount())
                    .build());
        } else {
            throw new RuntimeException("No sufficient fonds");
        }
    }
}
