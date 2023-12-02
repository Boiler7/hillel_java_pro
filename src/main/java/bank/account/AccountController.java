package bank.account;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/accounts/")
    public List<AccountDto> accounts(Pageable pageable) {
        return accountService.getAccounts(pageable);
    }

    @GetMapping("/accounts/{uid}")
    public Optional<AccountDto> account(@PathVariable("uid") String uid){
        return accountService.getAccount(uid);
    }

    @PostMapping("/accounts")
    public AccountDto createAccount(@RequestBody AccountDto request) {
        return accountService.create(request);
    }

    @PutMapping("/accounts/{uid}")
    public AccountDto updateAccount(
            @PathVariable("uid") String uid,
            @RequestBody AccountDto request) {
        return accountService.update(uid, request);
    }

    @DeleteMapping("/accounts/{uid}")
    public void deleteAccount(@PathVariable("uid") String uid) {
        accountService.delete(uid);
    }

}