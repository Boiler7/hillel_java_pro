package HW25_Patterns_Integration_Testing;

import HW24_JDBC.Hero;
import HW24_JDBC.HeroDao;
import HW24_JDBC.HeroDaoImplementation;

import javax.sql.DataSource;
import java.util.List;

public interface HeroFabric{
    public HeroService createService();


}
