package fr.pizzeria.dao.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import fr.pizzeria.model.Pizza;

@Component
@Aspect
public class GreffonCodeDepuisNom {

	@Before("execution(* fr.pizzeria.dao.datajpa.*.save(..)) && args(pizza)")
	public void siCodeVideAlorsNom(Pizza pizza) {
		if (("").equals(pizza.getCode())) {
			pizza.setCode(pizza.getNom().toUpperCase().substring(0, 3));
			System.out.println(pizza);
		}

	}
}
