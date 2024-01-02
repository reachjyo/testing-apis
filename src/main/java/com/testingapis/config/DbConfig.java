package com.testingapis.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    @Bean(name="dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/realestate");
        dataSource.setUsername("postgresql");
        dataSource.setPassword("postgresql");
        return dataSource;
    }

    @Bean(name ="namedParameterJdbcTemplate")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("dataSource") final DataSource requestDataSource) {
        return new NamedParameterJdbcTemplate(requestDataSource);
    }

    @Bean(name ="jdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") final DataSource requestDataSource) {
        return new JdbcTemplate(requestDataSource);
    }


}
