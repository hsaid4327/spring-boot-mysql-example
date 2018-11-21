package guru.springframework.datasources;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class Datasource {

    @Bean
    public DataSource testDataSource() {
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUrl("jdbc:mysql://localhost:3306");
        bds.setUsername("root");
        bds.setPassword("root");
        bds.setTestWhileIdle(true);
        bds.setValidationQuery("SELECT 1");
        return bds;
    }

}
