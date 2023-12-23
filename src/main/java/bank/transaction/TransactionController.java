package bank.transaction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransactionController {
    private TransactionService transactionService;
    @PostMapping("/api/transactions")
    public void transaction(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam int amount){
        transactionService.makeTransaction(from, to, amount);
    }
}
