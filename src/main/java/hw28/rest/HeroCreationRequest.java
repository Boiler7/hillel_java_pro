package hw28.rest;

public record HeroCreationRequest(
//        Long id,
        String name,
        String gender,
        String eyeColor,
        String race,
        String hairColor,
        double height,
        String publisher,
        String skinColor,
        String alignment,
        int weight
){


}