package fr.pizzeria.console;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import fr.pizzeria.dao.PizzaDaoSpringJpa;
import fr.pizzeria.dao.SpringJpa.JpaCoreConfig;

@Configuration
@ComponentScan("fr.pizzeria.ihm")
@Import({ JpaCoreConfig.class, PizzaDaoSpringJpa.class })
public class PizzeriaConfig {

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
		c.setLocation(new ClassPathResource("application.properties"));
		return c;
	}
}
