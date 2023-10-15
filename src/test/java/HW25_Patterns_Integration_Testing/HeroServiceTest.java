package HW25_Patterns_Integration_Testing;

import HW18_Lambda_ExpressionCSV.Hero;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.sql.DataSource;
import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
class HeroServiceTest {
//    List<Hero> heroes = List.of(
//            new Hero("Abin Sur", "Male", "blue", "Ungaran", "No Hair", 185, "DC Comics", "red", "good", 90),
//            new Hero("Agent Zero", "Male", "-", "-", "-", 191, "Marvel Comics", "-", "good", 104),
//            new Hero("Alex Mercer", "Male", "-", "Human", "-", -99, "Wildstorm", "-", "bad", -99),
//            new Hero("Abin Sur", "Male", "blue", "Ungaran", "No Hair", 185, "DC Comics", "red", "good", 90),
//            new Hero("Abin Sur", "Male", "blue", "Ungaran", "No Hair", 185, "DC Comics", "red", "good", 90)
//    );
//    private HeroService target = new HeroService(heroes);




    @InjectMocks
    private HeroService heroService;

    @Mock
    private DataSource dataSource;

    @Mock
    private Connection connection;

    @Mock
    private Statement statement;

    @Mock
    private ResultSet resultSet;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        when(dataSource.getConnection()).thenReturn(connection);
        when(connection.createStatement()).thenReturn(statement);
    }

    @Test
    void testFindAll() throws Exception {
        when(statement.executeQuery(Mockito.anyString())).thenReturn(resultSet);

        when(resultSet.next()).thenReturn(true, true, false);
        when(resultSet.getString("name")).thenReturn("Superman", "Batman");

        Array arrayMock = Mockito.mock(Array.class);
        when(arrayMock.getArray()).thenReturn(new String[]{});
        when(resultSet.getArray("movie")).thenReturn(arrayMock);

        List<HeroDto> heroes = heroService.getHeroes();

        assertEquals(2, heroes.size());
    }
}