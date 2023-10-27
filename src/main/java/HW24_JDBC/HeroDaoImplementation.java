package HW24_JDBC;

import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class HeroDaoImplementation implements HeroDao {
    private final DataSource dataSource;
    private ArrayList<Hero> heroes;

    @Override
    public List<Hero> findAll() {
        var sql = "select * from heroes";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            var result = statement.executeQuery(sql);
            return mapHeroes(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ArrayList<Hero> mapHeroes(ResultSet result) throws SQLException {
        heroes = new ArrayList<Hero>();
        while (result.next()) {
            heroes.add(Hero.builder()
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
        return heroes;
    }

    @Override // Remake using prepare statement
    public List<Hero> findByName(String name) {
        var sql = "select * from heroes where Name = '" + name + "'";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            var result = statement.executeQuery(sql);
            return mapHeroes(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Hero hero) {
        var sql = "insert into heroes(name,gender,eye_color, race, hair_color, height, publisher, skin," +
                "alignment, weight) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (var connection = dataSource.getConnection();
            var statement = connection.prepareStatement(sql)) {
            statement.setString(1, hero.name);
            statement.setString(2, hero.gender);
            statement.setString(3, hero.eyeColor);
            statement.setString(4, hero.race);
            statement.setString(5, hero.hairColor);
            statement.setDouble(6, hero.height);
            statement.setString(7, hero.publisher);
            statement.setString(8, hero.skinColor);
            statement.setString(9, hero.alignment);
            statement.setLong(10, hero.weigh);
            statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Hero hero) {
        var sql = "update heroes set id = ?, name = ? where name = ?";
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.setLong(1, hero.id);
            statement.setString(2, hero.name);
            statement.setString(3, hero.name);
            statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Long id) {
        var sql = "delete from heroes where Id = ?";
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
