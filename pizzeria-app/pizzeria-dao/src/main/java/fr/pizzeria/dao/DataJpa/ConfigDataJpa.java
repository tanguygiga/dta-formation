package fr.pizzeria.dao.DataJpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
// @ComponentScan("fr.pizzeria.dao")
@EnableJpaRepositories("fr.pizzeria.dao.DataJpa")
public class ConfigDataJpa {

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		return new LocalEntityManagerFactoryBean();

	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		return txManager;
	}
}