package hw32.spring.data.jpa.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUid(String id);

    public void deleteByUid(String uid);
}
