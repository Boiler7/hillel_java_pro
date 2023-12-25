package bank.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    @PostMapping("/transactions")
    public void transaction(
            @RequestBody TransactionDto request){
        transactionService.makeTransaction(request);
    }
}
