package HW24_JDBC;

import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class HeroDaoImplementation implements HeroDao{
    private final DataSource dataSource;
    private ArrayList<Hero> heroes;
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
        heroes = new ArrayList<Hero>();
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
                    .weigh(result.getInt("weight"))
                    .build());
        }
        return heroes;
    }

//    @Override // Remake using prepare statement
//    public List<Hero> findByName(String name) {
//        var sql = "select * from public.heroes where name = ? ";
//        try (var connection = dataSource.getConnection();
//             var statement = connection.prepareStatement(sql)) {
//            statement.setString(1, name);
//            var result = statement.executeQuery(sql);
//            return mapHeroes(result);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @Override // Remake using prepare statement
//    public List<Hero> findByName(String name) {
//        var sql = "SELECT * FROM public.heroes WHERE heroes.name = ?";
//        try (var connection = dataSource.getConnection();
//             var statement = connection.prepareStatement(sql)) {
//            statement.setString(1, name);
//            var result = statement.executeQuery(); // Removed the SQL query argument
//            return mapHeroes(result);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override // Remake using prepare statement
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
        var sql = "insert into heroes(name, gender, eye_color, race, hair_color, height, publisher, skin, alignment, weight) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            statement.setDouble(10, hero.weigh);

            statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Hero hero) {
        var sql = "update heroes set id = ?, name = ? where id = ? AND name = ?";
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.setLong(1, hero.id);
            statement.setString(2, hero.name);
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
                statement.executeQuery(sql);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return false;
    }
}
