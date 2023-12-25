package bank.transaction;

import bank.NumberGenerator;
import bank.account.Account;
import bank.account.AccountDto;
import bank.account.AccountService;
import bank.card.Card;
import bank.card.CardRepository;
import bank.card.CardStatus;
import bank.person.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

class TransactionServiceTest {

    @Mock
    private AccountService accountService;
    @Mock
    private CardRepository cardRepository;
    @Mock
    private TransactionRepository transactionRepository;
    @InjectMocks
    private TransactionService transactionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        transactionService = new TransactionService(accountService, cardRepository, transactionRepository);
    }

    @Test
    void shouldMakeTransaction() {
        TransactionDto transactionDto = new TransactionDto("1234567890","0987654321", 100);

        Card cardFrom = new Card("cardId", new Person(), new Account(), "pan", NumberGenerator.generateExpirationDate(),
                "0000", "000", CardStatus.ACTIVE);

        Card cardTo = new Card("cardId", new Person(), new Account(), "pan", NumberGenerator.generateExpirationDate(),
                "0000", "000", CardStatus.ACTIVE);

        Mockito.when(cardRepository.findByPan(eq("1234567890"))).thenReturn(Optional.of(cardFrom));
        Mockito.when(cardRepository.findByPan(eq("0987654321"))).thenReturn(Optional.of(cardTo));

        Mockito.when(accountService.update(eq(cardFrom.getAccount().getUid()), any(AccountDto.class)))
                .thenReturn(new AccountDto("accountId", 100, "1"));

        Mockito.when(accountService.update(eq(cardTo.getAccount().getUid()), any(AccountDto.class)))
                .thenReturn(new AccountDto("accountId", 100, "2"));

        transactionService.makeTransaction(transactionDto);

        verify(cardRepository).findByPan(eq("1234567890"));
        verify(cardRepository).findByPan(eq("0987654321"));

        verify(accountService).update(eq(cardFrom.getAccount().getUid()), any(AccountDto.class));
        verify(accountService).update(eq(cardTo.getAccount().getUid()), any(AccountDto.class));
    }
}