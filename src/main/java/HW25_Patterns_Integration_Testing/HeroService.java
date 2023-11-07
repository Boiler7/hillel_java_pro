package HW25_Patterns_Integration_Testing;

import HW24_JDBC.Hero;
import HW24_JDBC.HeroDao;

import java.util.List;

public class HeroService {

    private final HeroDao heroDao;
    private final HeroMovieService heroMovieService;

    public HeroService(HeroDao heroDao, HeroMovieService heroMovieService) {
        this.heroDao = heroDao;
        this.heroMovieService = heroMovieService;
    }

    public HeroDto updateHero(HeroDto heroDto, long id) {
        heroDao.update(Hero.builder()
                        .name(heroDto.getName())
                        .id(id)
                        .build());
        return getHeroById(id);
    }

    public List<HeroDto> getHeroes() {
        return heroDao.findAll().stream()
                .map(hero -> map(hero))
                .toList();
    }

    public HeroDto map(Hero hero) {
        return HeroDto.builder()
                .name(hero.getName())
                .movies(heroMovieService.getPlayedIn(hero.getName()))
                .build();
    }
}
