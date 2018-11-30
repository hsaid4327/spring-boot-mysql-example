package guru.springframework.datasources;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class Datasource {

    @Bean
    public DataSource provideMysqlDS() {
        String mysqlHost = System.getenv("MYSQL_SERVICE_HOST");
        String mysqlPort = System.getenv("MYSQL_SERVICE_PORT");
        String formattedHostAndPort = mysqlHost + ":" + mysqlPort;
        String mysqlDb = System.getenv("MYSQL_DB");
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUrl("jdbc:mysql://" + formattedHostAndPort + "/" + mysqlDb);
        bds.setUsername("root");
        bds.setPassword("root");
        bds.setTestWhileIdle(true);
        bds.setValidationQuery("SELECT 1");
        return bds;
    }

}
