package fr.pizzeria.dao.SpringJpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
// @ComponentScan("fr.pizzeria.dao")
@EnableTransactionManagement
public class JpaCoreConfig {

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		return new LocalEntityManagerFactoryBean();

	}

	@Bean
	public PlatformTransactionManager txManager() {
		return new JpaTransactionManager();

	}
}