package HW28_REST;

public record HeroCreationRequest(
        Long id,
        String name,
        String gender,
        String eyeColor,
        String race,
        String hairColor,
        double height,
        String publisher,
        String skinColor,
        String alignment,
        int weigh
){}