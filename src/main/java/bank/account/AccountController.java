package bank.account;

import bank.person.PersonDto;
import bank.person.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/accounts/")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping()
    public List<AccountDto> accounts(Pageable pageable) {
        return accountService.getAccounts(pageable);
    }
    @GetMapping("/{id}")
    public Optional<AccountDto> account(@PathVariable("id") Long id){
        return accountService.getAccount(id);
    }
    @PostMapping("create")
    public AccountDto createAccount(@RequestBody AccountDto request) {
        return accountService.create(request);
    }

    @PutMapping("/update/{id}")
    public AccountDto updateAccount(
            @PathVariable("id") Long id,
            @RequestBody AccountDto request) {
        return accountService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAccount(@PathVariable("id") String uid) {
        accountService.delete(uid);
    }
}
