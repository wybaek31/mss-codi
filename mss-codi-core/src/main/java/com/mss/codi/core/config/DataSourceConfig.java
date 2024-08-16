package com.mss.codi.core.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
@EnableJpaAuditing
@EntityScan(basePackages = {"com.mss.codi.core.domain"})
@EnableJpaRepositories(basePackages = {"com.mss.codi.core.repository"})
public class DataSourceConfig {

    private final Environment env;

    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .driverClassName(env.getProperty("spring.datasource.driver-class-name"))
                .url(env.getProperty("spring.datasource.url"))
                .username(env.getProperty("spring.datasource.username"))
                .password(env.getProperty("spring.datasource.password"))
                .build();
    }
}