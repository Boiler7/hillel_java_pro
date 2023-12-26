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
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

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
        Person person = mock(Person.class);
        when(person.getUid()).thenReturn("2");

        Account accountFrom = mock(Account.class);
        when(accountFrom.getBalance()).thenReturn(100);
        when(accountFrom.getPerson()).thenReturn(person);

        Card cardFrom = new Card("cardFromId", person, accountFrom, "fromCard",
                NumberGenerator.generateExpirationDate(), "cvvFrom", "pinFrom", CardStatus.ACTIVE);

        Account accountTo = mock(Account.class);
        when(accountTo.getBalance()).thenReturn(50);
        when(accountTo.getPerson()).thenReturn(person);

        when(cardRepository.findByPan(eq("fromCard"))).thenReturn(Optional.of(cardFrom));
        when(cardRepository.findByPan(eq("toCard"))).thenReturn(Optional.of(new Card("cardToId", person, accountTo, "toCard",
                NumberGenerator.generateExpirationDate(), "cvvTo", "pinTo", CardStatus.ACTIVE)));

        when(accountService.update(any(), any()))
                .thenReturn(new AccountDto("idFrom", "ibanFrom", 50, "2"))
                .thenReturn(new AccountDto("idTo", "ibanTo", 100, "2"));

        verify(cardRepository, times(2)).findByPan(anyString());
        verify(accountService, times(2)).update(any(), any());
        verify(transactionRepository).save(any());
    }
}