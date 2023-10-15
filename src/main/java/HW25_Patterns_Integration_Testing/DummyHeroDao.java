package HW25_Patterns_Integration_Testing;

import HW24_JDBC.Hero;
import HW24_JDBC.HeroDao;
import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RequiredArgsConstructor
public class DummyHeroDao implements HeroDao{
    private final List<Hero> db;
    private DataSource dataSource;

    public DummyHeroDao(List<Hero> db, DataSource dataSource) {
        this.db = db;
        this.dataSource = dataSource;
    }
    public List<Hero> findAll() {
        return db;
    }
    @Override
    public List<Hero> findByName(String name) {
        var sql = "select * from heroes where name = '" + name + "'";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            var result = statement.executeQuery(sql);
            return mapHeroes(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private ArrayList<Hero> mapHeroes(ResultSet result) throws SQLException {
        var students = new ArrayList<Hero>();
        while (result.next()) {
            students.add(Hero.builder()
                    .id(result.getLong("Id"))
                    .name(result.getString("Name"))
                    .gender(result.getString("Gender"))
                    .eyeColor(result.getString("Eye Color"))
                    .race(result.getString("Race"))
                    .hairColor(result.getString("Hair Color"))
                    .height(result.getDouble("Height"))
                    .publisher(result.getString("Publisher"))
                    .skinColor(result.getString("Skin Color"))
                    .alignment(result.getString("Alignment"))
                    .weigh(result.getInt("Weight"))
                    .build());
        }
        return students;
    }
    @Override
    public void create(Hero hero) {

    }

    @Override
    public void update(Hero hero) {

    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
