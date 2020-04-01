package harkat.MoveList;

import com.zaxxer.hikari.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

  @Value("${spring.datasource.url}")
  private String dbUrl;
  
  @Value("${spring.datasource.password}")
  private String dbpassword;
  
  @Value("${spring.datasource.username}")
  private String dbusername;

  @Bean
  public DataSource dataSource() {
      HikariConfig config = new HikariConfig();
      config.setUsername(dbusername);
      config.setPassword(dbpassword);
      config.setJdbcUrl(dbUrl);
      return new HikariDataSource(config);
  }
}