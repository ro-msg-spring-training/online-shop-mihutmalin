package ro.msg.learning.shop.Configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@SuppressWarnings("unused")
public class DatabaseConfguration {
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String devDatabaseConnection(){
        System.out.println(driverClassName);
        System.out.println(url);
        return "Connection with DB for DEV";
    }

    @Profile("test")
    @Bean
    public String testDatabaseConnection(){
        System.out.println(driverClassName);
        System.out.println(url);
        return "Connection with DB for TEST";
    }

    @Profile("prod")
    @Bean
    public String prodDatabaseConnection(){
        System.out.println(driverClassName);
        System.out.println(url);
        return "Connection with DB for PROD";
    }
}
