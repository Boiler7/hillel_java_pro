package HW25_Patterns_Integration_Testing;


import java.util.ArrayList;
import java.util.List;

public class HeroMovieService {
    private List<HeroDto> heroDtoList;

    protected HeroMovieService(List<HeroDto> heroDtoList) {
        this.heroDtoList = heroDtoList;
    }
    public List<String> getPlayedIn(String heroName) {
        for (var heroes: heroDtoList){
            if(heroes.getMovies().equals(heroName)){
                return heroes.getMovies();
            }
        }
        return List.of();
    }
}
