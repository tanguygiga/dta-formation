package fr.pizzeria.console;

import fr.pizzeria.model.Pizza;

public class afficher {

}

	public static void afficher(Pizza[] tableauPizza) {
		for (int i = 0; i < tableauPizza.length; ++i) {
			System.out.println(i + 1 + ". " + tableauPizza[i].getCode() + " -> " + tableauPizza[i].getNom() + " ("
					+ tableauPizza[i].getPrix() + " €)");
		}
	}

}
