package HW25_Patterns_Integration_Testing;



import lombok.Builder;

import java.util.List;

//@Builder
public class HeroDto {
    private String name;
    private List<String> movies;

    public String getName() {
        return name;
    }

    public List<String> getMovies() {
        return movies;
    }

    // Private constructor to create instances using the builder
    private HeroDto(String name, List<String> movies) {
        this.name = name;
        this.movies = movies;
    }

    public static class Builder {
        private String name;
        private List<String> movies;

        public Builder name(String name) {
            this.name = name;
            return this; // Return the builder instance for method chaining
        }

        public Builder movies(List<String> movies) {
            this.movies = movies;
            return this; // Return the builder instance for method chaining
        }

        public HeroDto build() {
            // Perform any validation if needed
            return new HeroDto(name, movies);
        }
    }
}