package com.infybuzz.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DatabaseConfiguration {
	
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	};
	
	@Bean
	@ConfigurationProperties(prefix = "spring.studentdatasource")
	public DataSource studentDataSource() {
		return DataSourceBuilder.create().build();
	};
	
	@Bean
	@ConfigurationProperties(prefix = "spring.postgresdatasource")
	public DataSource postgresDataSource() {
		return DataSourceBuilder.create().build();
	};

}
