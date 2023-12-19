package bank.card;

import bank.account.Account;
import bank.entity.BaseEntity;
import bank.person.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cards")
@EntityListeners(AuditingEntityListener.class)
public class Card extends BaseEntity {
    String uid;
    private String pan;
    @ManyToOne
    @JoinColumn(name="person_id")
    private Person person;
    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;
    private Date expirationDate;
    private String pin;
    private String cvv;
    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;

}
