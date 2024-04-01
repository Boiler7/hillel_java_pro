package bank.transaction;

import bank.account.Account;
import bank.card.Card;
import bank.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")
@EntityListeners(AuditingEntityListener.class)
public class Transaction extends BaseEntity {
    private String uid;
    @ManyToOne
    private Card fromCard;
    @ManyToOne
    private Account fromAccount;
    @ManyToOne
    private Card toCard;
    @ManyToOne
    private Account toAccount;
    private int amount;
}
