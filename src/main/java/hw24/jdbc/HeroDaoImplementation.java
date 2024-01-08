package hw24.jdbc;

import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class HeroDaoImplementation implements HeroDao{
    private final DataSource dataSource;
    @Override
    public List<Hero> findAll() {
        var sql = "select * from heroes";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()){
            var result = statement.executeQuery(sql);
            return mapHeroes(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ArrayList<Hero> mapHeroes(ResultSet result) throws SQLException {
        var heroes = new ArrayList<Hero>();
        while (result.next()) {
            heroes.add(Hero.builder()
                    .id(result.getLong("id"))
                    .name(result.getString("name"))
                    .gender(result.getString("gender"))
                    .eyeColor(result.getString("eye_color"))
                    .race(result.getString("race"))
                    .hairColor(result.getString("hair_color"))
                    .height(result.getDouble("height"))
                    .publisher(result.getString("publisher"))
                    .skinColor(result.getString("skin"))
                    .alignment(result.getString("alignment"))
                    .weight(result.getInt("weight"))
                    .build());
        }
        return heroes;
    }

    @Override
    public List<Hero> findByName(String name) {
        var sql = "SELECT * FROM public.heroes WHERE heroes.name = '"+name+"'";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            var result = statement.executeQuery(sql);
            return mapHeroes(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Hero> findById(long id) {
        var sql = "select * from heroes where id = '" + id + "'";
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
        var sql = "insert into heroes(name, gender, eye_color, race, hair_color, height, publisher, skin, alignment," +
                " weight) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            statement.setDouble(10, hero.weight);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Hero hero) {
        var sql = "update heroes set name = ?, eye_color = ?, race = ?, hair_color = ?, height = ?, publisher = ?, " +
                "skin = ?, alignment = ?, weight = ?, gender = ? where id = ?";
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.setString(1, hero.name);
            statement.setString(2, hero.eyeColor);
            statement.setString(3, hero.race);
            statement.setString(4, hero.hairColor);
            statement.setDouble(5, hero.height);
            statement.setString(6, hero.publisher);
            statement.setString(7, hero.skinColor);
            statement.setString(8, hero.alignment);
            statement.setLong(9, hero.weight);
            statement.setString(10, hero.gender);
            statement.setLong(11, hero.id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Long id) {
            var sql = "delete from heroes where id = ?";
            try (var connection = dataSource.getConnection();
                 var statement = connection.prepareStatement(sql)) {
                statement.setLong(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return false;
    }
}
