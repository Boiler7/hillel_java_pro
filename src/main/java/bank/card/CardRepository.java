package bank.card;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {
    Optional<Card> findByUid(String id);
    void deleteByUid(String uid);
    Optional<Card> findByPan(String pan);
}
