package fr.pizzeria.dao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import fr.pizzeria.dao.aspects.GreffonCodeDepuisNom;
import fr.pizzeria.dao.datajpa.ConfigDataJpa;
import fr.pizzeria.dao.datajpa.PizzaDaoImplDataJpa;

@Configuration
// @ComponentScan("fr.pizzeria.dao")
@Import({ ConfigDataJpa.class, PizzaDaoImplDataJpa.class, GreffonCodeDepuisNom.class })
@EnableAspectJAutoProxy
public class DaoConfigTest {

	/*
	 * @Bean public DataSource dataSource() { return new
	 * EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript(
	 * "init-schema.sql").build(); }
	 */

}
