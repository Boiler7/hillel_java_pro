package bank.card;

import bank.NumberGenerator;
import bank.account.AccountRepository;
import bank.person.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CardService {
    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;
    private final PersonRepository personRepository;

    public CardService(CardRepository cardRepository, AccountRepository accountRepository, PersonRepository personRepository) {
        this.cardRepository = cardRepository;
        this.accountRepository = accountRepository;
        this.personRepository = personRepository;
    }

    public CardDto openCard(String personId, String accountId){
        var person = personRepository.findByUid(personId)
                .orElseThrow(() -> new RuntimeException("No person found"));
        var account = accountRepository.findByUid(accountId)
                .orElseThrow(() -> new RuntimeException("No account found"));

        var card = cardRepository.save(Card.builder()
                .uid(UUID.randomUUID().toString())
                .pan(NumberGenerator.generatePAN())
                .cvv(NumberGenerator.generateCVV())
                .pin(NumberGenerator.generatePIN())
                .cardStatus(CardStatus.WAITING)
                .expirationDate(NumberGenerator.generateExpirationDate())
                .account(account)
                .person(person)
                .build());


        return new CardDto(card.uid, card.getPerson().getUid(), card.getAccount().getUid());
    }
}
