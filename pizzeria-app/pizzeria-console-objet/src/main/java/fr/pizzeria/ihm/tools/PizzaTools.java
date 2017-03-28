package fr.pizzeria.ihm.tools;

import java.util.Scanner;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaTools {

	private Scanner scanner;

	public PizzaTools(Scanner scanner) {
		this.scanner = scanner;
	}

	public Pizza saisir() {

		System.out.println("Veuillez saisir le code");
		String code = this.scanner.nextLine().toUpperCase();

		System.out.println("Veuillez saisir le nom (sans espaces)");
		String nom = this.scanner.nextLine();

		System.out.println("Veuillez saisir le prix");
		Double prix = this.scanner.nextDouble();

		System.out.println("Veuillez saisir le numéro de la catégorie :");
		CategoriePizza[] categories = CategoriePizza.values();

		for (int i = 0; i < categories.length; i++) {
			System.out.println(i + 1 + " : " + categories[i].getLibelle());
		}

		int choixCategory = this.scanner.nextInt();
		this.scanner.nextLine();
		CategoriePizza category = categories[choixCategory - 1];

		return new Pizza(code, nom, prix, category);
	}
}
