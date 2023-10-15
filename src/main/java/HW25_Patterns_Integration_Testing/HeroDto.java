package HW25_Patterns_Integration_Testing;



import java.util.List;
public class HeroDto {
    private String name;
    private List<String> movies;
    public static HeroDtoBuilder builder(){
        return new HeroDtoBuilder();
    }

    public String getName() {
        return name;
    }

    public List<String> getMovies() {
        return movies;
    }

    private HeroDto(HeroDtoBuilder builder){
        this.name = builder().name;
        this.movies = builder().movies;
    }
    public static class HeroDtoBuilder {
        private String name;
        private List<String> movies;


        public HeroDtoBuilder name(String name){
            this.name = name;
            return this;
        }

        public HeroDtoBuilder List(List<String> movies){
            this.movies = movies;
            return this;
        }

        public HeroDto build(){
            return new HeroDto(this);
        }
    }
}