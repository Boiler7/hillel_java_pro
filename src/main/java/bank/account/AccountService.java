package bank.account;

import bank.NumberGenerator;
import bank.person.Person;
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
        var person = personRepository.findById(Long.valueOf(request.personId()))
                .orElseThrow(() -> new RuntimeException("Person not found"));

        return convertAccount(accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban("UA" + NumberGenerator.generateIBAN())
                .balance(0)
                .person(Person.builder()
                        .id(person.getId())
                        .uid(person.getUid())
                        .build())
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
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

    public Optional<AccountDto> getAccount(String uid) {
        return accountRepository.findByUid(uid).map(this::convertAccount);
    }

    public void delete(String uid) {
        var account = getRequiredAccount(uid);
        accountRepository.deleteByUid(account.getPerson().getUid());
    }

    private Account getRequiredAccount(String uid) {
        return accountRepository.findByUid(uid)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @Transactional
    public AccountDto update(String id, AccountDto request) {
        var account = getRequiredAccount(id);

        account.setBalance(request.balance());
        return convertAccount(accountRepository.save(account));
    }
}