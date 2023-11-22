package HW28_REST;

import HW24_JDBC.HeroDaoImplementation;
import HW25_Patterns_Integration_Testing.HeroMovieService;
import HW25_Patterns_Integration_Testing.HeroService;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class RestApplication {
    @Bean
    public HeroService heroService(){
        return new HeroService(new HeroDaoImplementation(dataSource()), new HeroMovieService());
    }
//    public static void main(String[] args) {
//        SpringApplication.run(RestApplication.class, args);
//    }

    private static DataSource dataSource() {
        var ds = new PGSimpleDataSource();
        ds.setServerNames(new String[]{"localhost"});
        ds.setDatabaseName("postgres");
        ds.setUser("hillel");
        ds.setPassword("hillel");
        return ds;
    }
}
