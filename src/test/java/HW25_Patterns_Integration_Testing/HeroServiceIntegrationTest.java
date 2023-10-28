package HW25_Patterns_Integration_Testing;

import HW24_JDBC.Hero;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroServiceIntegrationTest {
    private final HeroFabricImp heroFabricImp = new HeroFabricImp();
    HeroService target = heroFabricImp.createService(List.of(
            new Hero(1L,"Abin Sur", "Male", "blue", "Ungaran", "No Hair", 185.0, "DC Comics", "red", "good", 90),
            new Hero(2L,"Agent Zero", "Male", "-", "-", "-", 191, "Marvel Comics", "-", "good", 104),
            new Hero(3L,"Alex Mercer", "Male", "-", "Human", "-", -99, "Wildstorm", "-", "bad", -99),
            new Hero(4L,"Abinn Sur", "Male", "blue", "Ungaran", "No Hair", 185, "DC Comics", "red", "good", 90),
            new Hero(5L, "Abinnn Sur", "Male", "blue", "Ungaran", "No Hair", 185, "DC Comics", "red", "good", 90)
    ));

    @Test
    void shouldReturnListOfHeroes() {
        List<HeroDto> heroDtos = target.getHeroes();
        assertEquals(5, heroDtos.size());
    }
}
