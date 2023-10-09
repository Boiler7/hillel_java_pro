package HW18_Lambda_ExpressionCSV;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    void shouldGetAverageHigh() {
        List<Hero> list = List.of(
                new Hero("Abin Sur", "Male", "blue", "Ungaran", "No Hair",185,
                        "DC Comics", "red", "good", 90),
                new Hero("Agent Zero", "Male","-", "-", "-", 191, "Marvel Comics",
                        "-","good",104),
                new Hero("Alex Mercer","Male","-", "Human", "-", -99,"Wildstorm","-",
                        "bad",-99)
                );

        assertEquals(92.33333333333333, Hero.getAverageHigh(list));
    }

    @Test
    void shouldGetNameOfHighest() {
        List<Hero> list = List.of(
                new Hero("Abin Sur", "Male", "blue", "Ungaran", "No Hair",185,
                        "DC Comics", "red", "good", 90),
                new Hero("Agent Zero", "Male","-", "-", "-", 191, "Marvel Comics",
                        "-","good",104),
                new Hero("Alex Mercer","Male","-", "Human", "-", -99,"Wildstorm","-",
                        "bad",-99)
        );
        assertEquals("Agent Zero", Hero.getNameOfHighest(list));
    }

    @Test
    void shouldGetNameOfHeaviest() {
        List<Hero> list = List.of(
                new Hero("Abin Sur", "Male", "blue", "Ungaran", "No Hair",185,
                        "DC Comics", "red", "good", 90),
                new Hero("Agent Zero", "Male","-", "-", "-", 191, "Marvel Comics",
                        "-","good",104),
                new Hero("Alex Mercer","Male","-", "Human", "-", -99,"Wildstorm","-",
                        "bad",-99)
        );
        assertEquals("Agent Zero", Hero.getNameOfHeaviest(list));
    }

    @Test
    void shouldGetPersonsGenderGroup() {
        List<Hero> list = List.of(
                new Hero("Abin Sur", "Male", "blue", "Ungaran", "No Hair",185,
                        "DC Comics", "red", "good", 90),
                new Hero("Agent Zero", "Male","-", "-", "-", 191, "Marvel Comics",
                        "-","good",104),
                new Hero("Alex Mercer","Male","-", "Human", "-", -99,"Wildstorm","-",
                        "bad",-99)
        );
        var expectedResult = Map.of(
                "Male", 3
        );

        var personsAlignment = Hero.getPersonsGenderGroup(list);
        assertThat(personsAlignment, Matchers.is(expectedResult));
    }

    @Test
    void shouldGetPersonsAlignment() {
        List<Hero> list = List.of(
                new Hero("Abin Sur", "Male", "blue", "Ungaran", "No Hair",185,
                        "DC Comics", "red", "good", 90),
                new Hero("Agent Zero", "Male","-", "-", "-", 191, "Marvel Comics",
                        "-","good",104),
                new Hero("Alex Mercer","Male","-", "Human", "-", -99,"Wildstorm","-",
                        "bad",-99)
        );
        var expectedResult = Map.of(
                "good", 2,
                "bad", 1
                );
        var personsAlignment = Hero.getPersonsAlignment(list);
        assertThat(personsAlignment, Matchers.is(expectedResult));
    }

    @Test
    void shouldGet5PopularPublishers() {
        List<Hero> list = List.of(
                new Hero("Abin Sur", "Male", "blue", "Ungaran", "No Hair",185,
                        "DC Comics", "red", "good", 90),
                new Hero("Agent Zero", "Male","-", "-", "-", 191, "Marvel Comics",
                        "-","good",104),
                new Hero("Alex Mercer","Male","-", "Human", "-", -99,"Wildstorm","-",
                        "bad",-99)

        );
        List<String> popularPublishers = Hero.get5PopularPublishers(list);

        assertThat(popularPublishers, Matchers.containsInAnyOrder("DC Comics", "Marvel Comics", "Wildstorm"));    }

    @Test
    void shouldGet3PopularHairColor() {
        List<Hero> list = List.of(
                new Hero("Abin Sur", "Male", "blue", "Ungaran", "No Hair",185,
                        "DC Comics", "red", "good", 90),
                new Hero("Agent Zero", "Male","-", "-", "-", 191, "Marvel Comics",
                        "-","good",104),
                new Hero("Alex Mercer","Male","-", "Human", "-", -99,"Wildstorm","-",
                        "bad",-99),
                new Hero("Angel Dust","Female", "yellow", "Mutant","Black",165,
                        "Marvel Comics", "-", "good", 57)
        );


        List<String> popularHairColor = Hero.get3PopularHairColor(list);

        assertThat(popularHairColor, Matchers.containsInAnyOrder("No Hair", "-", "Black"));
    }

    @Test
    void shouldGetPopularEyeColor() {
        List<Hero> list = List.of(
            new Hero("Abin Sur", "Male", "blue", "Ungaran", "No Hair",185,
                    "DC Comics", "red", "good", 90),
            new Hero("Agent Zero", "Male","-", "-", "-", 191, "Marvel Comics",
                    "-","good",104),
            new Hero("Alex Mercer","Male","-", "Human", "-", -99,"Wildstorm","-",
                    "bad",-99),
            new Hero("Abin Sur", "Male", "blue", "Ungaran", "No Hair",185,
                        "DC Comics", "red", "good", 90),
            new Hero("Abin Sur", "Male", "blue", "Ungaran", "No Hair",185,
                        "DC Comics", "red", "good", 90)
    );
        assertEquals("blue", Hero.getPopularEyeColor(list));
    }
}