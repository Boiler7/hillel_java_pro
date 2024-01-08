package hw25.patterns.integration.testing;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class HeroDto {
    private Long id;
    private String name;
    private String gender;
    private String eyeColor;
    private String race;
    private String hairColor;
    private double height;
    private String publisher;
    private String skinColor;
    private String alignment;
    private int weight;
    private List<String> movies;


}