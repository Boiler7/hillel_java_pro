package HW25_Patterns_Integration_Testing;

import HW24_JDBC.Hero;
import HW24_JDBC.HeroDao;
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


    public HeroDto updateHero(long id, HeroDto heroDto) {
        heroDao.update(Hero.builder()
                .id(heroDto.getId())
                .name(heroDto.getName())
                .eyeColor(heroDto.getEyeColor())
                .race(heroDto.getRace())
                .hairColor(heroDto.getHairColor())
                .height(heroDto.getHeight())
                .publisher(heroDto.getPublisher())
                .skinColor(heroDto.getSkinColor())
                .alignment(heroDto.getAlignment())
                .weight(heroDto.getWeight())
                .gender(heroDto.getGender())
                .build());
        return getHeroById(id);
    }

    public void create(HeroCreationRequest request) {
        var hero = new Hero(null, request.name(), request.gender(), request.eyeColor(), request.race(),
                request.hairColor(), request.height(), request.publisher(), request.skinColor(), request.alignment(),
                request.weight());
        heroDao.create(hero);
    }


    public HeroDto map(Hero hero) {
        return HeroDto.builder()
                .id(hero.getId())
                .name(hero.getName())
                .eyeColor(hero.getEyeColor())
                .race(hero.getRace())
                .hairColor(hero.getHairColor())
                .height(hero.getHeight())
                .publisher(hero.getPublisher())
                .skinColor(hero.getSkinColor())
                .alignment(hero.getAlignment())
                .weight(hero.getWeight())
                .gender(hero.getGender())
                .build();
    }

    public boolean delete(long id) {
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
