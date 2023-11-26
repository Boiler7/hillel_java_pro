package bank.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long>{
    Optional<Person> findByUid(String id);

    @Modifying
    @Query("UPDATE Person SET name = :name WHERE id = :id")
    Optional<Person> updatePersonById(@Param("name") String name, @Param("id") Long id);
}
