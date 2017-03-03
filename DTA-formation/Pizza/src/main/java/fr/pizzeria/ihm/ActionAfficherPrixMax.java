package fr.pizzeria.ihm;

import java.util.List;
import java.util.stream.Collectors;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.tools.IhmTools;

public class ActionAfficherPrixMax extends Action {

	@Override
	void faireAction(IhmTools ihmTools) {

		List<Pizza> tableauPizza = ihmTools.getPizzaDao().findAllPizzas();

		double prixMax = tableauPizza.stream().max((p1, p2) -> Double.compare(p1.getPrix(), p2.getPrix())).get()
				.getPrix();

		List<Pizza> result = tableauPizza.stream().filter(p -> p.getPrix().equals(prixMax))
				.collect(Collectors.toList());

		result.forEach(p -> System.out.println(p));

	}

	@Override
	String getLibelle() {
		return "Afficher les PIZZAs les plus ch�res";
	}

}
