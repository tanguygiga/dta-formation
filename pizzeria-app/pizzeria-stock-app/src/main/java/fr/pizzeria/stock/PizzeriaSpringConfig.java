package fr.pizzeria.stock;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import fr.pizzeria.dao.datajpa.ConfigDataJpa;
import fr.pizzeria.dao.datajpa.IngredientDaoImplDataJpa;

@Configuration
@EnableWebMvc
@ComponentScan("fr.pizzeria.stock.controller")
@Import({ ConfigDataJpa.class, IngredientDaoImplDataJpa.class })
public class PizzeriaSpringConfig {

}
