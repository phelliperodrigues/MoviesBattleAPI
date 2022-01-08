package dev.phelliperodrigues.moviebattle.config.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties("spring.datasource")
@SuppressWarnings("unused")
@Slf4j
public class DBConfig {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String devDatabaseConnection(){
        log.info("DB Connection from DEV - H2");
        log.info(driverClassName);
        log.info(url);

        return "DB Connection from DEV  - H2";
    }

    @Profile("test")
    @Bean
    public String testDatabaseConnection(){
        log.info("DB Connection from TEST - H2");
        log.info(driverClassName);
        log.info(url);

        return "DB Connection from TEST  - H2";
    }

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Profile("prod")
    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        return new HikariDataSource(config);
    }
    @Profile("prod")
    @Bean
    public String prodDatabaseConnection(){
        log.info("DB Connection from PROD - POSTGRES");
        log.info(driverClassName);
        log.info(url);

        return "DB Connection from PROD  - POSTGRES";
    }
}
