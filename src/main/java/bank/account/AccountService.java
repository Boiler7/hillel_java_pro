package bank.account;

import bank.NumberGenerator;
import bank.person.Person;
import bank.person.PersonDto;
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
                .person_id(request.person_id())
                .build()));
    }

    private AccountDto convertAccount(Account account) {
        return new AccountDto(account.getUid(), account.getIban(), account.getBalance(), account.getPerson_id());
    }

    public List<AccountDto> getAccounts(Pageable pageable) {
        return accountRepository.findAll((pageable)).stream()
                .map(this::convertAccount)
                .toList();
    }

    public void delete(Long id) {
        accountRepository.deleteById(id);
    }

    public AccountDto update(String id) {
        return convertAccount(accountRepository.updateAccount(id).get());
    }
}
