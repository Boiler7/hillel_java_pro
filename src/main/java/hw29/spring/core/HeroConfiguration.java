package hw29.spring.core;

import HW24_JDBC.HeroDao;
import HW24_JDBC.HeroDaoImplementation;
import HW25_Patterns_Integration_Testing.HeroMovieService;
import HW25_Patterns_Integration_Testing.HeroService;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan("hw29.spring.core")
public class HeroConfiguration {
    @Bean
    public HeroService heroService(HeroDao heroDao, HeroMovieService heroMovieService){
        return new HeroService(heroDao, heroMovieService);
    }
    @Bean
    public HeroDao heroDao(DataSource dataSource){
        return new HeroDaoImplementation(dataSource);
    }

    @Bean
    public DataSource dataSource() {
        var ds = new PGSimpleDataSource();
        ds.setServerNames(new String[]{"localhost"});
        ds.setDatabaseName("postgres");
        ds.setUser("hillel");
        ds.setPassword("hillel");
        return ds;
    }

    @Bean
    public HeroMovieService heroMovieService(){
        return new HeroMovieService();
    }
}
