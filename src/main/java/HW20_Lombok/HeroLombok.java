package HW20_Lombok;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class HeroLombok {
    private String name;
    private String gender;
    private String eyeColor;
    private String race;
    private String hairColor;
    private double height;
    private String publisher;
    private String skinColor;
    private String alignment;
    private int weigh;

}
