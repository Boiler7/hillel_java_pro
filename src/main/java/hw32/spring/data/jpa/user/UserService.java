package hw32.spring.data.jpa.user;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto create(UserDto request){
        return convertUser(userRepository.save(User.builder()
                .uid(UUID.randomUUID().toString())
                .name(request.name())
                .email(request.email())
                .role(request.role())
                .build()));
    }

    private UserDto convertUser(User user){
        return new UserDto(user.getUid(), user.getName(), user.getEmail(), user.getRole());
    }

    public UserDto getUser(String uid){
        return userRepository.findByUid(uid)
                .map(this::convertUser)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Transactional
    public UserDto update(String uid, UserDto request){
        User user = userRepository.findByUid(uid)
                .orElseThrow();

        user.setName(request.name());
        user.setEmail(request.email());
        user.setRole(request.role());
        return convertUser(userRepository.save(user));
    }

    public void delete(String uid){
        userRepository.deleteByUid(uid);
    }
}
