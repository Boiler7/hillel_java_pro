package bank.transaction;

import bank.account.AccountDto;
import bank.account.AccountRepository;
import bank.account.AccountService;
import bank.card.CardRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private AccountRepository accountRepository;
    private AccountService accountService;
    private CardRepository cardRepository;

    @Transactional
    public void makeTransaction(String from, String to, int amount) {
        var cardFrom = cardRepository.findByPan(from).orElseThrow(() -> new RuntimeException("Sender's card is not found"));
        var cardTo = cardRepository.findByPan(to).orElseThrow(() -> new RuntimeException("Receiver's card is not found"));

        var balanceFrom = cardFrom.getAccount().getBalance();

        var accountId = cardFrom.getAccount().getUid();
        if (balanceFrom >= amount ){
            var accountFromUpdate = accountService.getAccount(accountId).orElseThrow();
            accountService.update(accountId, new AccountDto(accountFromUpdate.id(), accountFromUpdate.iban(),
                    accountFromUpdate.balance() -amount, accountFromUpdate.personId()));

            var accountToUpdate = cardTo.getAccount();
            accountService.update(accountToUpdate.getUid(), new AccountDto(accountToUpdate.getIban(), accountToUpdate.getBalance() + amount, accountToUpdate.getPerson().getUid()));
        } else {
            throw new RuntimeException("No sufficient fonds");
        }

    }
}
