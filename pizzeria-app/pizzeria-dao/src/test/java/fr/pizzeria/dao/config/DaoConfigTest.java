package fr.pizzeria.dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import fr.pizzeria.dao.aspects.GreffonCodeDepuisNom;
import fr.pizzeria.dao.datajpa.PizzaDaoImplDataJpa;

@Configuration
@EnableAspectJAutoProxy
@Import({ PizzaDaoImplDataJpa.class, GreffonCodeDepuisNom.class })
@EnableJpaRepositories("fr.pizzeria.repo")
public class DaoConfigTest {

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
