package bank.person;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long>{
    Optional<Person> findByUid(String id);

    void deleteByUid(String uid);
}
