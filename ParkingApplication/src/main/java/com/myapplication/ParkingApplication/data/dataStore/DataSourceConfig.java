package com.myapplication.ParkingApplication.data.dataStore;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean //Connection Bean -- since it is a bean, it will be available to the application using autowired annotation, we won't use it rather we are using entity manager
    public DataSource dataSource() {
        return DataSourceBuilder.create().driverClassName("com.mysql.cj.jdbc.Driver").url("jdbc:mysql://localhost:3306/ParkingSystem").username("dev").password("password").build();
    }
}
