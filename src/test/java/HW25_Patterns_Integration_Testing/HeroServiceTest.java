package HW25_Patterns_Integration_Testing;

import HW24_JDBC.Hero;
import HW24_JDBC.HeroDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
class HeroServiceTest {
//    List<Hero> heroes = List.of(
//            new Hero(1L,"Abin Sur", "Male", "blue", "Ungaran", "No Hair", 185.0, "DC Comics", "red", "good", 90),
//            new Hero(2L,"Agent Zero", "Male", "-", "-", "-", 191, "Marvel Comics", "-", "good", 104),
//            new Hero(3L,"Alex Mercer", "Male", "-", "Human", "-", -99, "Wildstorm", "-", "bad", -99),
//            new Hero(4L,"Abin Sur", "Male", "blue", "Ungaran", "No Hair", 185, "DC Comics", "red", "good", 90),
//            new Hero(5L, "Abin Sur", "Male", "blue", "Ungaran", "No Hair", 185, "DC Comics", "red", "good", 90)
//    );
    private HeroService target;
    @Mock
    private HeroDao heroDao;
    @Mock
    private HeroMovieService heroMovieService;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        target = new HeroService(heroDao,heroMovieService);
    }


    @Test
    void shouldReturnListOfHeroes() {
        List<HeroDto> heroDtos = target.getHeroes();
        assertEquals(0, heroDtos.size());

    } }