package hw25.patterns.integration.testing;

import hw24.jdbc.Hero;
import hw24.jdbc.HeroDao;

import java.util.List;


public class DummyHeroDao implements HeroDao {
    private final List<Hero> db;

    public DummyHeroDao(List<Hero> db) {
        this.db = db;
    }

    public List<Hero> findAll() {
        return db;
    }

    @Override
    public List<Hero> findByName(String name) {
        return db.stream()
                .filter(hero -> hero.getName().equals(name))
                .toList();
    }

    @Override
    public List<Hero> findById(long id) {
        return List.of();
    }


    @Override
    public void create(Hero hero) {
        db.add(hero);
    }

    @Override
    public void update(Hero hero) {

    }

    @Override
    public boolean delete(Long id) {
        if (db.size() >= id) {
            db.remove(id - 1);
            return true;
        }
        return false;
    }
}
