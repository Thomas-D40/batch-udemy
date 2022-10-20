package com.infybuzz.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

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
	
	@Bean
	public EntityManagerFactory postgresqlEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lem = new LocalContainerEntityManagerFactoryBean();
		
		lem.setDataSource(postgresDataSource());
		lem.setPackagesToScan("com.infybuzz.postgresql.entity");
		lem.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		lem.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		
		lem.afterPropertiesSet();
		
		return lem.getObject();
	}
	
	@Bean
	public EntityManagerFactory mysqlEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lem = new LocalContainerEntityManagerFactoryBean();
		
		lem.setDataSource(studentDataSource());
		lem.setPackagesToScan("com.infybuzz.mysql.entity");
		lem.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		lem.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		
		lem.afterPropertiesSet();
		
		return lem.getObject();
	}
	
	@Bean
	@Primary
	public JpaTransactionManager jpaTransactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		
		jpaTransactionManager.setDataSource(studentDataSource());
		jpaTransactionManager.setEntityManagerFactory(mysqlEntityManagerFactory());
		
		return jpaTransactionManager;
	}

}
