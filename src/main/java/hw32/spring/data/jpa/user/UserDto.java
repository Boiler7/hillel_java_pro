package hw32.spring.data.jpa.user;

public record UserDto(
    String id,
    String name,
    String email,
    UserRole role
    ){}
