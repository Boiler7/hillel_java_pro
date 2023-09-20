package HW20_Lombok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroValueTest {

    @Test
    void shouldGetFields() {
        var hero = new HeroLombok("Abraxas", "Male", "blue", "Cosmic Entity", "Black",-99,
                "Marvel Comics","-", "bad", 441);

        assertEquals("Abraxas", hero.getName());
        assertEquals("Male", hero.getGender());
        assertEquals("blue", hero.getEyeColor());
    }
}