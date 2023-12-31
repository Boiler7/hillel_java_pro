package bank.account;

import bank.person.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final PersonRepository personRepository;

    public AccountService(AccountRepository accountRepository, PersonRepository personRepository) {
        this.accountRepository = accountRepository;
        this.personRepository = personRepository;
    }

    public AccountDto create(AccountDto request) {
        var person = personRepository.findByUid(request.personId())
                .orElseThrow();

        return convertAccount(accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban(request.iban())
                .balance(0)
                .person(person)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build()));
    }

    public AccountDto convertAccount(Account account) {
        return new AccountDto(account.getUid(), account.getIban(), account.getBalance(), account.getPerson().getUid());
    }

    public List<AccountDto> getAccounts(Pageable pageable) {
        return accountRepository.findAll((pageable)).stream()
                .map(this::convertAccount)
                .toList();
    }

    public Optional<AccountDto> getAccount(String id) {
        return accountRepository.findByUid(id).map(this::convertAccount);
    }

    public void delete(String id) {
        var account = getRequiredAccount(id);
        accountRepository.deleteByUid(account.getPerson().getUid());
    }

    private Account getRequiredAccount(String id) {
        return accountRepository.findByUid(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @Transactional
    public AccountDto update(String id, AccountDto request) {
        var account = getRequiredAccount(id);

        account.setBalance(request.balance());
        return convertAccount(accountRepository.save(account));
    }
}