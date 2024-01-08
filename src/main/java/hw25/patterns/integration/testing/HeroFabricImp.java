package hw25.patterns.integration.testing;

import hw24.jdbc.Hero;
import hw24.jdbc.HeroDaoImplementation;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.util.List;

public class HeroFabricImp implements HeroFabric{

    @Override
    public HeroService createService(){
        return new HeroService(new HeroDaoImplementation(dataSource()),new HeroMovieService());
    }
    private static DataSource dataSource() {
        var ds = new PGSimpleDataSource();
//        ds.setServerNames(new String[]{"localhost"});
        ds.setDatabaseName("postgres");
        ds.setUser("hillel");
        ds.setPassword("hillel");
        return ds;
    }
    public HeroService createService(List<Hero> db){
        return new HeroService( new DummyHeroDao(db),new HeroMovieService());
    }
}
