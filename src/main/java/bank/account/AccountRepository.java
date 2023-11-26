package bank.account;

import bank.person.Person;
import bank.person.PersonDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUid(String id);

    @Modifying
    @Query("UPDATE Account set id = ?1")
    Optional<Account> updateAccount(String id);
}
