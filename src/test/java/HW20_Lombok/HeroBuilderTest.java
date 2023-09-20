package HW20_Lombok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroBuilderTest {

    @Test
    void shouldGet(){
        HeroBuilder hero = new HeroBuilder("Abraxas", "Male", "blue", "Cosmic Entity", "Black", -99,
                "Marvel Comics", "-", "bad", 441, new HeroBuilder.Address("Wilder St.",
                "Philadelphia", "Pennsylvania", "USA"));
    }
}