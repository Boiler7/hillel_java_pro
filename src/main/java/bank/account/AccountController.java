package bank.account;

import bank.person.PersonDto;
import bank.person.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/accounts/")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("")
    public List<AccountDto> accounts(Pageable pageable) {
        return accountService.getAccounts(pageable);
    }

    @PostMapping("create")
    public AccountDto createAccount(@RequestBody AccountDto request) {
        return accountService.create(request);
    }

    @PutMapping("/update/{id}")
    public AccountDto updateAccount(
            @PathVariable("id") String id) {
        return accountService.update(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAccount(@PathVariable("id") Long id) {
        accountService.delete(id);
    }
}
