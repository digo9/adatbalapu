package hu.itguruk.allaskeresoportal.configuration;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan
public class DatabaseConfiguration {

  /**
   * Database connection trough oracle jdbc driver
   * 
   * @return dataSoruce
   */
  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSoruce = new DriverManagerDataSource();
    dataSoruce.setDriverClassName(oracle.jdbc.driver.OracleDriver.class.getName());
    dataSoruce.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
    dataSoruce.setUsername("system");
    dataSoruce.setPassword("1234");
    return dataSoruce;
  }
}
