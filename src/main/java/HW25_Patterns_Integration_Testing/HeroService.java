package HW25_Patterns_Integration_Testing;

import HW24_JDBC.Hero;
import HW24_JDBC.HeroDao;
import HW24_JDBC.HeroDaoImplementation;
import HW28_REST.HeroCreationRequest;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.util.List;

public class HeroService {

    private final HeroDao heroDao;
    private final HeroMovieService heroMovieService;

    public HeroService(HeroDao heroDao, HeroMovieService heroMovieService) {
        this.heroDao = heroDao;
        this.heroMovieService = heroMovieService;
    }

    public List<HeroDto> getHeroes() {
        return heroDao.findAll().stream()
                .map(this::map)
                .toList();
    }

    public HeroDto getHeroById(long id) {
        return map(heroDao.findById(id).get(0));
    }


    public void create(HeroCreationRequest request) {
        var heroDaoImp = new HeroDaoImplementation(dataSource());
        var hero = new Hero(null, request.name(), request.gender(), request.eyeColor(), request.race(), request.hairColor(),
                request.height(), request.publisher(), request.skinColor(), request.alignment(), request.weigh());
        heroDaoImp.create(hero);
    }


    public HeroDto updateHero(long id, HeroDto heroDto) {
        heroDao.update(Hero.builder()
                .name(heroDto.getName())
                .id(id)
                .build());
        return getHeroById(id);
    }

    public HeroDto map(Hero hero) {
        return HeroDto.builder()
                .name(hero.getName())
                .movies(heroMovieService.getPlayedIn(hero.getName()))
                .build();
    }

    public boolean delete(long id){
        return heroDao.delete(id);
    }

    private static DataSource dataSource() {
        var ds = new PGSimpleDataSource();
//        ds.setServerNames(new String[]{"localhost"});
        ds.setDatabaseName("postgres");
        ds.setUser("hillel");
        ds.setPassword("hillel");
        return ds;
    }
}
