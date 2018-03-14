package hu.itguruk.allaskeresoportal.configuration;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan
public class DatabaseConfiguration {

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName(oracle.jdbc.driver.OracleDriver.class.getName());
    ds.setUrl("jdbc:oracle:thin:@localhost:4000:kabinet");
    // h-s azonosító és pw megadása
    ds.setUsername("");
    ds.setPassword("");
    return ds;
  }
}
