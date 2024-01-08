package hw31.mvc;

import hw24.jdbc.HeroDaoImplementation;
import hw25.patterns.integration.testing.HeroMovieService;
import hw25.patterns.integration.testing.HeroService;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringMvcConfig {
    @Bean
    public HeroService heroService(DataSource dataSource) {
        return new HeroService(new HeroDaoImplementation(dataSource), new HeroMovieService());
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
}