package fr.pizzeria.stock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import fr.pizzeria.dao.datajpa.ConfigDataJpa;
import fr.pizzeria.dao.datajpa.IngredientDaoImplDataJpa;

@Configuration
@EnableWebMvc
@ComponentScan("fr.pizzeria.stock.controller")
@Import({ ConfigDataJpa.class, IngredientDaoImplDataJpa.class })
public class PizzeriaSpringConfig {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

}
