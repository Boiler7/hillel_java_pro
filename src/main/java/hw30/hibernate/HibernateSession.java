package hw30.hibernate;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import javax.sql.DataSource;

@Configuration
@ComponentScan("hw30.hibernate")
public class HibernateSession {
    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
        var sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("hw30.hibernate");
        return sessionFactory;
    }

    @Bean
    public static DataSource dataSource() {
        var ds = new PGSimpleDataSource();
        ds.setServerNames(new String[]{"localhost"});
        ds.setDatabaseName("postgres");
        ds.setUser("hillel");
        ds.setPassword("hillel");
        return ds;
    }
}
