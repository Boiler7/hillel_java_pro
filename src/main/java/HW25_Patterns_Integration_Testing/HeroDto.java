package HW25_Patterns_Integration_Testing;



import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class HeroDto {
    private Long id;
    private String name;
    private String gender;
    private String eyeColor;
    private String race;
    private String hairColor;
    private double height;
    private String publisher;
    private String skinColor;
    private String alignment;
    private int weight;
    private List<String> movies;

    //    public String getName() {
//        return name;
//    }
//
    public List<String> getMovies() {
        return movies;
    }
//
//    public Long getId() {
//        return id;
//    }

//    private HeroDto(String name, List<String> movies) {
//        this.name = name;
//        this.movies = movies;
//    }

//    public static class Builder {
//        private String name;
//        private List<String> movies;
//
//        public Builder name(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public Builder movies(List<String> movies) {
//            this.movies = movies;
//            return this;
//        }
//
//        public HeroDto build() {
//            return new HeroDto(name, movies);
//        }
//
//        public Builder id(Long id) {
//            return this;
//        }
//    }
}