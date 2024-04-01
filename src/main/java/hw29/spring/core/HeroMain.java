package hw29.spring.core;

import hw25.patterns.integration.testing.HeroService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HeroMain {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(HeroConfiguration.class);
        var repository = context.getBean(HeroService.class);

        var hero = repository.getHeroById(5);

        System.out.println("Name: " + hero.getName() + "\nMovies: " + hero.getMovies());
    }
}