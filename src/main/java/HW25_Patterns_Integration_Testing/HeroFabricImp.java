package HW25_Patterns_Integration_Testing;

import HW24_JDBC.Hero;

import javax.sql.DataSource;
import java.util.List;

public class HeroFabricImp implements HeroFabric{

    @Override
    public HeroService createService(DataSource dataSource){
        return new HeroService(dataSource);
    }


}
