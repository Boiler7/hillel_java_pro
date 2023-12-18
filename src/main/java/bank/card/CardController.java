package bank.card;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;
    @PostMapping("/persons/{personId}/accounts/{accountId}/cards")
    public CardDto openCard(
            @PathVariable String personId,
            @PathVariable String accountId){
        return cardService.openCard(personId, accountId);
    }
}
