package fr.pizzeria.ihm.tools;

import java.util.Scanner;

import fr.pizzeria.dao.IClientDao;
import fr.pizzeria.dao.IDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class IhmTools {
	private Scanner sc = new Scanner(System.in);
	private IDao<Pizza, String> daoPizza;
	private IClientDao daoClient;

	public IhmTools(IDao<Pizza, String> dao) {
		this.daoPizza = dao;
	}

	public IDao<Pizza, String> getDaoPizza() {
		return daoPizza;
	}

	public IClientDao getDaoClient() {
		return daoClient;
	}

	public Scanner getSc() {
		return sc;
	}

	public Pizza saisir() {

		System.out.println("Veuillez saisir le code");
		String code = getSc().nextLine().toUpperCase();

		System.out.println("Veuillez saisir le nom (sans espaces)");
		String nom = getSc().nextLine();

		System.out.println("Veuillez saisir le prix");
		Double prix = getSc().nextDouble();

		System.out.println("Veuillez saisir le numéro de la catégorie :");
		CategoriePizza[] categories = CategoriePizza.values();

		for (int i = 0; i < categories.length; i++) {
			System.out.println(i + 1 + " : " + categories[i].getLibelle());
		}

		int choixCategory = getSc().nextInt();
		getSc().nextLine();
		CategoriePizza category = categories[choixCategory - 1];

		return new Pizza(code, nom, prix, category);
	}
}
