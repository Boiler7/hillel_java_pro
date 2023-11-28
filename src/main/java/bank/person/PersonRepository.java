package bank.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long>{
    Optional<Person> findByUid(String id);

    @Modifying
    @Query("UPDATE Person SET name = ?1 WHERE uid = ?2")
    Optional<Person> updatePersonById( String name, String uid);

    @Query("DELETE Person WHERE uid = ?1")
    void deleteByUid(String uid);
}
