package HW25_Patterns_Integration_Testing;

import HW24_JDBC.Hero;

import javax.sql.DataSource;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeroService {
    private DataSource dataSource;
    private List<Hero> heroes;

    public HeroService(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public HeroService(List heroes) {
        this.heroes = heroes;
    }

    public List<HeroDto> getHeroes() {
        var sql = "select * from heroes";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()){
            var result = statement.executeQuery(sql);
            return mapHeroes(result);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private List<HeroDto> mapHeroes(ResultSet result) throws SQLException {
        var heroes = new ArrayList<HeroDto>();
        while (result.next()) {
            List<String> movies =
                    new ArrayList<>(Arrays.asList((String[]) result.getArray("movie").getArray()));
            HeroDto hero = HeroDto.builder()
                    .name(result.getString("name"))
                    .List(movies)
                    .build();
            heroes.add(hero);
        }
        return heroes;
    }
}
