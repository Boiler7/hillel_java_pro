package HW24_JDBC;

import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class HeroImplementation implements HeroDao{
    private final DataSource dataSource;
    @Override
    public List<Hero> findAll() {
        var sql = "select * from heroes";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()){
            var result = statement.executeQuery(sql);
            return mapHeroes(result);
        }catch (SQLException e){
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
        var sql = "insert into heroes(Id,Name,Gender,Eye Color) values(hero.Name, hero.gender, hero.eyeColor, hero.race, hero.hairColor, hero.height, hero.publisher, hero.skinColor, hero.alignment, hero.weigh)";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Hero hero) {
        var sql = "delete from heroes where Name = '" + hero.id + "'";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
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
