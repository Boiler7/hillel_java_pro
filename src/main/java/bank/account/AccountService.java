package bank.account;

import bank.NumberGenerator;
import bank.person.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountDto create(AccountDto request) {
        return convertAccount(accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban("UA" + NumberGenerator.generateIBAN())
                .balance(0)
                .person(Person.builder()
                        .uid(request.personUid())
                        .build())
                .build()));
    }

    private AccountDto convertAccount(Account account) {
        return new AccountDto(account.getUid(), account.getIban(), account.getBalance(), account.getPerson().getUid());
    }

    public List<AccountDto> getAccounts(Pageable pageable) {
        return accountRepository.findAll((pageable)).stream()
                .map(this::convertAccount)
                .toList();
    }

    public Optional<AccountDto> getAccount(Long id) {
        return accountRepository.findById(id).map(this::convertAccount);
    }

    public void delete(String uid) {
        accountRepository.deleteById(uid);
    }

    public AccountDto update(Long id, AccountDto request) {
        return convertAccount(accountRepository.updateAccount(id, request.balance()).get());
    }

}