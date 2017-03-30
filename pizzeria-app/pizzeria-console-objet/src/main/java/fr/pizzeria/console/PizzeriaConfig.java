package fr.pizzeria.console;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import fr.pizzeria.dao.aspects.GreffonCodeDepuisNom;
import fr.pizzeria.dao.datajpa.ConfigDataJpa;
import fr.pizzeria.dao.datajpa.PizzaDaoImplDataJpa;
import fr.pizzeria.ihm.IhmConfig;

@Configuration
@EnableAspectJAutoProxy
@Import({ IhmConfig.class, ConfigDataJpa.class, PizzaDaoImplDataJpa.class, GreffonCodeDepuisNom.class })
public class PizzeriaConfig {

}
