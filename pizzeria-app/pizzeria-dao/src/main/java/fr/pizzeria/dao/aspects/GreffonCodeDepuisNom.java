package fr.pizzeria.dao.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GreffonCodeDepuisNom {

	@Before("execution(* fr.pizzeria.dao.*.*(..))")
	public void siCodeVideAlorsNom() {
		System.out.println("Greffon en place !");
	}
}
