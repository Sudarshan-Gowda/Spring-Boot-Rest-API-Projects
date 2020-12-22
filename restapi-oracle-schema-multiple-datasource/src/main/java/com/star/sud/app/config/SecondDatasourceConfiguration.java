package com.star.sud.app.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.star.sud.app.shoppingcart.repository", entityManagerFactoryRef = "secondEntityManagerFactory", transactionManagerRef = "secondTrasactionManager")
@EnableTransactionManagement
public class SecondDatasourceConfiguration {

	@Bean(name = "secondDs")
	@ConfigurationProperties(prefix = "spring.datasource.second")
	public DataSource secondDatasource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory(
			final EntityManagerFactoryBuilder builder) {
		return builder.dataSource(secondDatasource()).packages("com.star.sud.app.shoppingcart.entity")
				.persistenceUnit("secondPersistenceUnit").build();
	}

	@Bean
	public JpaTransactionManager secondTrasactionManager(
			@Qualifier("secondEntityManagerFactory") final EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}

	@Bean(name = "secondaryJdbcTemplate")
	public JdbcTemplate jdbcTemplate(@Qualifier("secondDs") DataSource ds) {
		return new JdbcTemplate(ds);
	}
}
