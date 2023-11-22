package HW24_JDBC;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@AllArgsConstructor
@Builder
public class Hero  {
    Long id;
    String name;
    String gender;
    String eyeColor;
    String race;
    String hairColor;
    double height;
    String publisher;
    String skinColor;
    String alignment;
    int weight;
}
