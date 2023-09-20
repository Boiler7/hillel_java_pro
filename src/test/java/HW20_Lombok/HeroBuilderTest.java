package HW20_Lombok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroBuilderTest {

    @Test
    void shouldGetFields(){

        var hero = HeroBuilder.builder()
                .name("Abraxas")
                .gender("Male")
                .eyeColor("blue")
                .build();

        assertEquals("Abraxas", hero.getName());
        assertEquals("Male", hero.getGender());
        assertEquals("blue", hero.getEyeColor());
    }
}