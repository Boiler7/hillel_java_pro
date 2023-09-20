package HW20_Lombok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroBuilderTest {

    @Test
    void shouldGet(){

        var hero = HeroBuilder.builder()
                .name("Abraxas")
                .gender("Male")
                .eyeColor("blue");

        assertEquals("Abraxas", hero.build().getName());
        assertEquals("Male", hero.build().getGender());
        assertEquals("blue", hero.build().getEyeColor());
    }
}