package bank.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    @PostMapping("/transactions")
    public TransactionStatus transaction(
            @RequestBody TransactionDto request){
        return transactionService.makeTransaction(request);
    }
}
