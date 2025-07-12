package com.anisse_bouainbi.tutorial.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConfig {
    
    @Bean
    public JdbcTemplate jdbcTemplate(final DataSource source) {
        return new JdbcTemplate(source);
    }
}
