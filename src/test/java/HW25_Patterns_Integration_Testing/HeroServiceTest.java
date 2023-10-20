package HW25_Patterns_Integration_Testing;

import HW24_JDBC.Hero;
import HW24_JDBC.HeroDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
class HeroServiceTest {
    List<Hero> heroes = List.of(
            new Hero(1L,"Abin Sur", "Male", "blue", "Ungaran", "No Hair", 185.0, "DC Comics", "red", "good", 90),
            new Hero(2L,"Agent Zero", "Male", "-", "-", "-", 191, "Marvel Comics", "-", "good", 104),
            new Hero(3L,"Alex Mercer", "Male", "-", "Human", "-", -99, "Wildstorm", "-", "bad", -99),
            new Hero(4L,"Abinn Sur", "Male", "blue", "Ungaran", "No Hair", 185, "DC Comics", "red", "good", 90),
            new Hero(5L, "Abinnn Sur", "Male", "blue", "Ungaran", "No Hair", 185, "DC Comics", "red", "good", 90)
    );

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
    void shouldGetHeroes(){
        Mockito.when(heroMovieService.getPlayedIn("Abin Sur")).thenReturn(List.of("Test1", "Test2"));
        Mockito.when(heroDao.findAll()).thenReturn(heroes);
        List<String> result = heroMovieService.getPlayedIn("Abin Sur");
        List<Hero> result1 = heroDao.findAll();

        assertThat(result, hasSize(2));
        assertThat(result1, hasSize(5));
    }
}