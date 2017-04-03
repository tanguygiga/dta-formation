package fr.pizzeria.stock.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import fr.pizzeria.dao.datajpa.IngredientDaoImplDataJpa;

@SpringBootApplication
@EnableJpaRepositories("fr.pizzeria.repo")
@EntityScan("fr.pizzeria.model")
@Import(IngredientDaoImplDataJpa.class)
public class PizzeriaStockAppSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzeriaStockAppSpringBootApplication.class, args);
	}

}
