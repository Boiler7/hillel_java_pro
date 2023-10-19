package HW25_Patterns_Integration_Testing;

import HW24_JDBC.Hero;
import HW24_JDBC.HeroDao;

import java.util.List;


public class DummyHeroDao implements HeroDao{
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
    public void create(Hero hero) {
        db.add(hero);
    }

    @Override
    public void update(Hero hero) {

    }

    @Override
    public boolean delete(Long id) {
        if(db.size() >= id){
            db.remove(id-1);
            return true;
        }
        return false;
    }
}
